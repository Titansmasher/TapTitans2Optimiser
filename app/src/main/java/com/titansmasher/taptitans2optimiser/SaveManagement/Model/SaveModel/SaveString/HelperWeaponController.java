package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class HelperWeaponController extends SaveAbstract<JSONObject> {

    private static String WEAPONSTOCOLLECT_KEY = "weaponsToCollect";
    private static String NEWLYCOLLECTEDWEAPONS = "newlyCollectedWeapons";
    public SaveList<String> weaponsToCollect;
    public SaveList<String> newlyCollectedWeapons;

    public HelperWeaponController() {
        super();
    }

    public HelperWeaponController(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        weaponsToCollect = new SaveList<String>() {
            @Override
            protected String getObjectValue(Object obj) {
                return (String) obj;
            }

            @Override
            protected Object getJsonValue(String value) {
                return value;
            }
        };
        newlyCollectedWeapons = new SaveList<String>() {
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
        weaponsToCollect.setJson(null);
        newlyCollectedWeapons.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        weaponsToCollect.setJson(this.getJSONArrayContent(obj, WEAPONSTOCOLLECT_KEY));
        newlyCollectedWeapons.setJson(this.getJSONArrayContent(obj, NEWLYCOLLECTEDWEAPONS));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, WEAPONSTOCOLLECT_KEY, weaponsToCollect.getJson());
        this.setContent(obj, NEWLYCOLLECTEDWEAPONS, newlyCollectedWeapons.getJson());

        return obj;
    }
}
