package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

/**
 * Created by Danny on 16/11/2016.
 */

public class BackgroundModel extends SaveAbstract<JSONObject> {
    private static String PLATFORMUNLOCKEDDICT_KEY = "platformUnlockedDict";
    public SaveDictionary<Boolean> platformUnlockedDict = new SaveDictionary<Boolean>() {
        @Override
        protected Boolean getJsonValue(JSONObject obj, String key) {
            return JSONHelpers.getBooleanSafe(obj, key, false);
        }

        @Override
        protected void setJsonValue(JSONObject obj, String key, Boolean value) {
            JSONHelpers.putSafe(obj, key, value);
        }
    };

    public BackgroundModel() {
        super();
    }

    public BackgroundModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        platformUnlockedDict = new SaveDictionary<Boolean>() {
            @Override
            protected Boolean getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getBooleanSafe(obj, key, false);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Boolean value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
    }

    @Override
    protected void populateFromNull() {
        platformUnlockedDict.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        platformUnlockedDict.setJson(JSONHelpers.getJSONObjectSafe(obj, PLATFORMUNLOCKEDDICT_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, PLATFORMUNLOCKEDDICT_KEY, platformUnlockedDict.getJson());

        return obj;
    }
}
