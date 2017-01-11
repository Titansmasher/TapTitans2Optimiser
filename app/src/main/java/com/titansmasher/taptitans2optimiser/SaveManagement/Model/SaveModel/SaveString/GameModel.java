package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class GameModel extends SaveAbstract<JSONObject> {

    private static String IGNOREDMESSAGEIDS_KEY = "ignoredMessageIds";
    private static String SAVEDAPPVERSION_KEY = "savedAppVersion";
    private static String PRODUCTION_KEY = "production";
    public SaveList<String> ignoredMessageIds;
    public String savedAppVersion;
    public Boolean production;

    public GameModel() {
        super();
    }

    public GameModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        ignoredMessageIds = new SaveList<String>() {
            @Override
            protected String getObjectValue(Object obj) {
                return (String) obj;
            }

            @Override
            protected Object getJsonValue(String value) {
                return value;
            }
        };
    }

    @Override
    protected void populateFromNull() {
        ignoredMessageIds.setJson(null);
        savedAppVersion = "";
        production = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        ignoredMessageIds.setJson(this.getJSONArrayContent(obj, IGNOREDMESSAGEIDS_KEY));
        savedAppVersion = this.getStringContent(obj, SAVEDAPPVERSION_KEY);
        production = this.getBooleanContent(obj, PRODUCTION_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, IGNOREDMESSAGEIDS_KEY, ignoredMessageIds.getJson());
        this.setContent(obj, SAVEDAPPVERSION_KEY, savedAppVersion);
        this.setContent(obj, PRODUCTION_KEY, production);

        return obj;
    }
}
