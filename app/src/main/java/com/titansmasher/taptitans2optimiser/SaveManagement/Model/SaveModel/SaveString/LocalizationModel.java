package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class LocalizationModel extends SaveAbstract<JSONObject> {
    private static String CURRENTLANGUAGE_KEY = "currentLanguage";
    public String currentLanguage;

    public LocalizationModel() {
        super();
    }

    public LocalizationModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        currentLanguage = "English";
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentLanguage = this.getStringContent(obj, CURRENTLANGUAGE_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, CURRENTLANGUAGE_KEY, currentLanguage);

        return obj;
    }
}
