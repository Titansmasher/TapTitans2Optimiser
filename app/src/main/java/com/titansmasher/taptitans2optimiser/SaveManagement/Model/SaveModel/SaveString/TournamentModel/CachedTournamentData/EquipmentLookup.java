package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel.CachedTournamentData;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 04/01/2017.
 */

public class EquipmentLookup extends SaveAbstract<JSONObject> {

    private static String EQUIPMENTCATEGORY_KEY = "EquipmentCategory";
    private static String LOOKID_KEY = "LookID";
    public String equipmentCategory;
    public String lookID;

    public EquipmentLookup() {
        super();
    }

    public EquipmentLookup(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        equipmentCategory = "";
        lookID = "";
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        equipmentCategory = this.getStringContent(obj, EQUIPMENTCATEGORY_KEY);
        lookID = this.getStringContent(obj, LOOKID_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, EQUIPMENTCATEGORY_KEY, equipmentCategory);
        JSONHelpers.putSafe(obj, LOOKID_KEY, lookID);

        return obj;
    }
}
