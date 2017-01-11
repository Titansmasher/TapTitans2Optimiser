package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.EquipmentModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class EquipmentModel extends SaveAbstract<JSONObject> {

    private static String ALLEQUIPMENT_KEY = "allEquipment";
    private static String ALLLOOKIDS_KEY = "allLookIDs";
    private static String LASTMAXSTAGE_KEY = "lastMaxStage";
    private static String EXTRAEQUIPMENTDROPS_KEY = "extraEquipmentDrops";
    public SaveDictionary<Equipment> allEquipment;
    public SaveList<String> allLookIDs;
    public Integer lastMaxStage;
    public SaveList<Integer> extraEquipmentDrops;

    public EquipmentModel() {
        super();
    }

    public EquipmentModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allEquipment = new SaveDictionary<Equipment>() {
            @Override
            protected Equipment getJsonValue(JSONObject obj, String key) {
                return new Equipment(JSONHelpers.getJSONObjectSafe(obj, key));
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Equipment value) {
                JSONHelpers.putSafe(obj, key, value.getJson());
            }
        };
        allLookIDs = new SaveList<String>() {
            @Override
            protected String getObjectValue(Object obj) {
                return (String) obj;
            }

            @Override
            protected Object getJsonValue(String value) {
                return value;
            }
        };
        extraEquipmentDrops = new SaveList<Integer>() {
            @Override
            protected Integer getObjectValue(Object obj) {
                return (Integer) obj;
            }

            @Override
            protected Object getJsonValue(Integer value) {
                return value;
            }
        };
    }

    @Override
    protected void populateFromNull() {
        allEquipment.setJson(null);
        allLookIDs.setJson(null);
        lastMaxStage = 0;
        extraEquipmentDrops.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        allEquipment.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLEQUIPMENT_KEY));
        allLookIDs.setJson(this.getJSONArrayContent(obj, ALLLOOKIDS_KEY));
        lastMaxStage = this.getIntegerContent(obj, LASTMAXSTAGE_KEY);
        extraEquipmentDrops.setJson(this.getJSONArrayContent(obj, EXTRAEQUIPMENTDROPS_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, ALLEQUIPMENT_KEY, allEquipment.getJson());
        this.setContent(obj, ALLLOOKIDS_KEY, allLookIDs.getJson());
        this.setContent(obj, LASTMAXSTAGE_KEY, lastMaxStage);
        this.setContent(obj, EXTRAEQUIPMENTDROPS_KEY, extraEquipmentDrops.getJson());

        return obj;
    }
}
