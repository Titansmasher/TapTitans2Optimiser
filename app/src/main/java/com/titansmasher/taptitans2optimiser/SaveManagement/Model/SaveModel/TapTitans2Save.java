package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 13/11/2016.
 */

public class TapTitans2Save extends SaveAbstract<JSONObject> {
    private static String PLAYERDATA_KEY = "playerData";
    private static String SAVESTRING_KEY = "saveString";
    private static String SAVECOUNT_KEY = "saveCount";
    public String playerData;
    public SaveStringModel saveString;
    public int saveCount;
    private boolean editable = true;

    public TapTitans2Save(JSONObject obj) {
        super(obj);
    }

    public TapTitans2Save(JSONObject obj, boolean editable) {
        this(obj);
        this.editable = editable;
    }

    public void populateFromNull() {
        playerData = "";
        saveString = new SaveStringModel();
        saveCount = 0;
    }

    public void populateFromJson(JSONObject obj) {
        playerData = JSONHelpers.getStringSafe(obj, PLAYERDATA_KEY);
        saveString = new SaveStringModel(JSONHelpers.constructJSONObjectSafe(JSONHelpers.getStringSafe(obj, SAVESTRING_KEY)));
        saveCount = JSONHelpers.getIntegerSafe(obj, SAVECOUNT_KEY);
    }

    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, PLAYERDATA_KEY, playerData);
        JSONHelpers.putSafe(obj, PLAYERDATA_KEY, saveString.getJson().toString());
        JSONHelpers.putSafe(obj, SAVECOUNT_KEY, saveCount);

        return obj;
    }

    public boolean isEditable() {
        return editable;
    }

}
