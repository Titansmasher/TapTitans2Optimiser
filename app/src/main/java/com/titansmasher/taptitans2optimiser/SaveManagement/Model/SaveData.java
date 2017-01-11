package com.titansmasher.taptitans2optimiser.SaveManagement.Model;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.TapTitans2Save;

import org.json.JSONObject;

/**
 * Created by Danny on 13/11/2016.
 */

public class SaveData {
    public TapTitans2Save save;
    public String saveName;

    public SaveData(String saveString, String name, boolean editable) {
        JSONObject obj = JSONHelpers.constructJSONObjectSafe(saveString);
        save = new TapTitans2Save(obj, editable);
        saveName = name;
    }

    public SaveData(String saveString, String name) {
        this(saveString, name, false);
    }
}
