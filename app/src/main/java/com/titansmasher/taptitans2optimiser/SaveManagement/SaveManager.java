package com.titansmasher.taptitans2optimiser.SaveManagement;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveData;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Danny on 13/11/2016.
 */

public class SaveManager {
    private static String SAVENAME_KEY = "savename";
    private static String SAVEDATA_KEY = "savedata";
    Map<Integer, SaveData> saves = new HashMap<>();
    private int curId = 0;
    private byte[] encryptionKey = hexStringToByteArray("4bc07927192f4e9a");

    public SaveManager(List<String> saveStrings) {
        for (String save :
                saveStrings) {
            JSONObject obj = JSONHelpers.constructJSONObjectSafe(save);
            String saveName = JSONHelpers.getStringSafe(obj, SAVENAME_KEY);
            String saveData = JSONHelpers.getStringSafe(obj, SAVEDATA_KEY);
            addSave(saveName, saveData, true);
        }
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public void addSave(String saveName, String saveData, boolean editable) {
        saves.put(curId++, new SaveData(saveData, saveName, editable));
    }

    public void addEncryptedSave(String saveName, byte[] bytes, boolean editable) {
        String decrypted = decrypt(bytes);
        if (decrypted != null)
            addSave(saveName, decrypted, editable);
    }

    public void removeSave(int saveId) {

    }

    private String decrypt(byte[] bytes) {
        byte[] iv = Arrays.copyOf(bytes, 8);

        bytes = Arrays.copyOfRange(bytes, 8, bytes.length);

        SecretKeySpec pKey = new SecretKeySpec(encryptionKey, "DES");
        IvParameterSpec iVectorSpecv = new IvParameterSpec(iv);

        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, pKey, iVectorSpecv);
            return new String(cipher.doFinal(bytes), "UTF-8");
        } catch (Exception ex) {
            return null;
        }
    }

    public Set<String> getSaves() {
        Set<String> strings = new HashSet<>();
        for (SaveData saveData :
                saves.values()) {
            if (!saveData.save.isEditable())
                continue;
            JSONObject obj = new JSONObject();
            JSONHelpers.putSafe(obj, SAVEDATA_KEY, saveData.save.getJson().toString());
            JSONHelpers.putSafe(obj, SAVENAME_KEY, saveData.saveName);
            strings.add(obj.toString());
        }

        return strings;
    }
}
