package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ActiveSkillModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

/**
 * Created by Danny on 15/11/2016.
 */

public class ActiveSkillModel extends SaveAbstract<JSONObject> {
    private static String ALLACTIVESKILLS_KEY = "allActiveSkills";
    public SaveDictionary<SkillModel> allActiveSkills;


    public ActiveSkillModel() {
        super();
    }

    public ActiveSkillModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allActiveSkills = new SaveDictionary<SkillModel>() {
            @Override
            protected SkillModel getJsonValue(JSONObject obj, String key) {
                return new SkillModel(JSONHelpers.getJSONObjectSafe(obj, key));
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, SkillModel value) {
                JSONHelpers.putSafe(obj, key, value.getJson());
            }
        };
    }

    @Override
    protected void populateFromNull() {
        allActiveSkills.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        allActiveSkills.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLACTIVESKILLS_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, ALLACTIVESKILLS_KEY, allActiveSkills.getJson());

        return obj;
    }
}
