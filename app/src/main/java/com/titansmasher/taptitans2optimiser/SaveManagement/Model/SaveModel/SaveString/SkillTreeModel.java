package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class SkillTreeModel extends SaveAbstract<JSONObject> {

    private static String IDTOLEVELDICT_KEY = "idToLevelDict";
    public SaveDictionary<Integer> idToLevelDict;

    public SkillTreeModel() {
        super();
    }

    public SkillTreeModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        idToLevelDict = new SaveDictionary<Integer>() {
            @Override
            protected Integer getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getIntegerSafe(obj, key);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Integer value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
    }

    @Override
    protected void populateFromNull() {
        idToLevelDict.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        idToLevelDict.setJson(JSONHelpers.getJSONObjectSafe(obj, IDTOLEVELDICT_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, IDTOLEVELDICT_KEY, idToLevelDict);

        return obj;
    }
}
