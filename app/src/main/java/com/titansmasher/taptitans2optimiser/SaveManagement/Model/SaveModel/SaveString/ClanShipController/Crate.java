package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanShipController;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class Crate extends SaveAbstract<JSONObject> {
    private static String FROMCLAN_KEY = "fromClan";
    private static String USERNAME_KEY = "userName";
    public Boolean fromClan;
    public String userName;

    public Crate() {
        super();
    }

    public Crate(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        fromClan = false;
        userName = "";
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        fromClan = JSONHelpers.getBooleanSafe(obj, FROMCLAN_KEY, false);
        userName = JSONHelpers.getStringSafe(obj, USERNAME_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, FROMCLAN_KEY, fromClan);
        JSONHelpers.putSafe(obj, USERNAME_KEY, userName);

        return obj;
    }
}
