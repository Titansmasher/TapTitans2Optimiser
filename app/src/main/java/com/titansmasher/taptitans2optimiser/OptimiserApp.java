package com.titansmasher.taptitans2optimiser;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;

import com.titansmasher.taptitans2optimiser.RemoteData.ArtifactInfo.ArtfactInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.EquipmentInfo.EquipmentInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.HelperImprovementsInfo.HelperImprovementInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.HelperInfo.HelperInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.HelperSkillInfo.HelperSkillInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.PetInfo.PetInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.PlayerImprovementsInfo.PlayerImprovementsInfo;
import com.titansmasher.taptitans2optimiser.RemoteData.SkillTreeInfo.SkillTreeInfo;
import com.titansmasher.taptitans2optimiser.SaveManagement.SaveManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Danny on 13/11/2016.
 */

public class OptimiserApp extends Application {
    public static OptimiserApp application;
    public SharedPreferences preferences;
    SaveManager saveManager;
    private String SAVES_KEY = "saves_key";

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        preferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        saveManager = new SaveManager(new ArrayList<String>());
        EquipmentInfo.refreshData();
        HelperInfo.refreshData();
        HelperImprovementInfo.refreshData();
        HelperSkillInfo.refreshData();
        PetInfo.refreshData();
        ArtfactInfo.refreshData();
        PlayerImprovementsInfo.refreshData();
        SkillTreeInfo.refreshData();
    }

    private byte[] getSaveFile() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + getString(R.string.tap_titans2_package) + "/files/ISavableGlobal.adat";

        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return bytes;
    }

    public void loadSaves() {
        List<String> saveStrings = new ArrayList<>();
        for (String save :
                preferences.getStringSet(SAVES_KEY, new HashSet<String>())) {
            saveStrings.add(save);
        }
        saveManager = new SaveManager(saveStrings);
        if (isTapTitansInstalled()) {
            byte[] saveBytes = getSaveFile();
            if (saveBytes != null)
                saveManager.addEncryptedSave("Tap Titans Save", saveBytes, false);
        }
    }

    public void saveSaves() {
        preferences.edit().putStringSet(SAVES_KEY, saveManager.getSaves()).commit();
    }

    public boolean isTapTitansInstalled() {
        try {
            this.getPackageManager().getApplicationInfo(getString(R.string.tap_titans2_package), 0);
            return true;
        } catch (PackageManager.NameNotFoundException ex) {
            return false;
        }
    }
}
