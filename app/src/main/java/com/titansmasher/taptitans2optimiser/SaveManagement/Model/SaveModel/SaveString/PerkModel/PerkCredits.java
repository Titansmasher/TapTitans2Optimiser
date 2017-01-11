package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.PerkModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class PerkCredits extends SaveAbstract<JSONObject> {

    private static String SPENT_KEY = "Spent";
    private static String RECIEVED_KEY = "Recieved";
    public Integer spent;
    public Integer recieved;
    private String baseKey;

    public PerkCredits(String baseKey) {
        populateFromNull();
        this.baseKey = baseKey;
    }

    public PerkCredits(JSONObject obj, String baseKey) {
        this.baseKey = baseKey;
        if (obj == null) {
            populateFromNull();
        } else {
            populateFromJson(obj);
        }
    }

    @Override
    protected void populateFromNull() {
        spent = 0;
        recieved = 0;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        spent = this.getIntegerContent(obj, this.baseKey + SPENT_KEY);
        recieved = this.getIntegerContent(obj, this.baseKey + RECIEVED_KEY);
    }

    @Override
    public JSONObject getJson() {
        return null;
    }

    public void addJson(JSONObject obj) {
        this.setContent(obj, this.baseKey + SPENT_KEY, spent);
        this.setContent(obj, this.baseKey + RECIEVED_KEY, recieved);
    }
}
