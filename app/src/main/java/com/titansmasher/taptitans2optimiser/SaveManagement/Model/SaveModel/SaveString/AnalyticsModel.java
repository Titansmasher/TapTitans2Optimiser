package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 16/11/2016.
 */

public class AnalyticsModel extends SaveAbstract<JSONObject> {
    private static String CANDOSWR_KEY = "canDoSwr";
    public Boolean canDoSwr;

    public AnalyticsModel() {
        super();
    }

    public AnalyticsModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        canDoSwr = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        canDoSwr = getBooleanContent(obj, CANDOSWR_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        setContent(obj, CANDOSWR_KEY, canDoSwr);

        return obj;
    }
}
