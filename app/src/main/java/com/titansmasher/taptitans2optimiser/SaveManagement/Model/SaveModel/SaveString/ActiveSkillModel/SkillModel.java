package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ActiveSkillModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 15/11/2016.
 */

public class SkillModel extends SaveAbstract<JSONObject> {
    private static String LEVEL_KEY = "level";
    private static String ACTIVETIME_KEY = "activeTime";
    private static String COOLDOWNTIME_KEY = "cooldownTime";
    public Integer level;
    public Double activeTime;
    public Double cooldown;

    public SkillModel() {
        super();
    }

    public SkillModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        level = 0;
        activeTime = 0d;
        cooldown = 0d;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        level = getIntegerContent(obj, LEVEL_KEY);
        activeTime = getDoubleContent(obj, ACTIVETIME_KEY);
        cooldown = getDoubleContent(obj, COOLDOWNTIME_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        setContent(obj, LEVEL_KEY, level);
        setContent(obj, ACTIVETIME_KEY, activeTime);
        setContent(obj, COOLDOWNTIME_KEY, cooldown);

        return obj;
    }
}
