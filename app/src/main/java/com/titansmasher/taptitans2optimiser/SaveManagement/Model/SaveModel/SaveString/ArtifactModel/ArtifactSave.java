package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ArtifactModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 16/11/2016.
 */

public class ArtifactSave extends SaveAbstract<JSONObject> {
    private static String LEVEL_KEY = "level";
    private static String RELICS_SPENT_KEY = "relics_spent";
    public Integer level;
    public Double relics_spent;

    public ArtifactSave() {
        super();
    }

    public ArtifactSave(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        level = 0;
        relics_spent = 0d;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        level = getIntegerContent(obj, LEVEL_KEY);
        relics_spent = getDoubleContent(obj, RELICS_SPENT_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        setContent(obj, LEVEL_KEY, level);
        setContent(obj, RELICS_SPENT_KEY, relics_spent);

        return obj;
    }
}
