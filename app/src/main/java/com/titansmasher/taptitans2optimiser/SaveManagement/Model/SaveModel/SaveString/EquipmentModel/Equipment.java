package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.EquipmentModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class Equipment extends SaveAbstract<JSONObject> {
    private static String EQUIPMENTID_KEY = "equipmentID";
    private static String LOOKID_KEY = "lookID";
    private static String UNIQUEID_KEY = "uniqueID";
    private static String EQUIPPED_KEY = "equipped";
    private static String LOCKED_KEY = "locked";
    private static String HIDDEN_KEY = "hidden";
    private static String LEVEL_KEY = "level";
    private static String ISNEW_KEY = "isNew";
    public String equipmentID;
    public String lookID;
    public Integer uniqueID;
    public Boolean equipped;
    public Boolean locked;
    public Boolean hidden;
    public Integer level;
    public Boolean isNew;


    public Equipment() {
        super();
    }

    public Equipment(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        equipmentID = "";
        lookID = "";
        uniqueID = 0;
        equipped = false;
        locked = false;
        hidden = false;
        level = 0;
        isNew = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        equipmentID = this.getStringContent(obj, EQUIPMENTID_KEY);
        lookID = this.getStringContent(obj, LOOKID_KEY);
        uniqueID = this.getIntegerContent(obj, UNIQUEID_KEY);
        equipped = this.getBooleanContent(obj, EQUIPPED_KEY, false);
        locked = this.getBooleanContent(obj, LOCKED_KEY, false);
        hidden = this.getBooleanContent(obj, HIDDEN_KEY, false);
        level = this.getIntegerContent(obj, LEVEL_KEY);
        isNew = this.getBooleanContent(obj, ISNEW_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, EQUIPMENTID_KEY, equipmentID);
        this.setContent(obj, LOOKID_KEY, lookID);
        this.setContent(obj, UNIQUEID_KEY, uniqueID);
        this.setContent(obj, EQUIPPED_KEY, equipped);
        this.setContent(obj, LOCKED_KEY, locked);
        this.setContent(obj, HIDDEN_KEY, hidden);
        this.setContent(obj, LEVEL_KEY, level);
        this.setContent(obj, ISNEW_KEY, isNew);

        return obj;
    }
}
