package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 01/01/2017.
 */

public class FairyController extends SaveAbstract<JSONObject> {
    public static String FATFAIRYLASTCOLLECTEDTIME_KEY = "fatFairyLastCollectedTime";
    public static String OPTIONFAIRYVIDEOON_KEY = "optionFairyVideoOn";
    public static String FIRSTSESSIONLASTCOLLECTEDTIME_KEY = "firstSessionLastCollectedTime";
    public Date fatFairyLastCollectedTime;
    public Boolean optionFairyVideoOn;
    public Date firstSessionLastCollectedTime;

    public FairyController() {
        super();
    }

    public FairyController(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        fatFairyLastCollectedTime = new Date(0);
        optionFairyVideoOn = true;
        firstSessionLastCollectedTime = new Date(0);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        fatFairyLastCollectedTime = this.getDate(this.getStringContent(obj, FATFAIRYLASTCOLLECTEDTIME_KEY));
        optionFairyVideoOn = this.getBooleanContent(obj, OPTIONFAIRYVIDEOON_KEY, true);
        firstSessionLastCollectedTime = this.getDate(this.getStringContent(obj, FIRSTSESSIONLASTCOLLECTEDTIME_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, FATFAIRYLASTCOLLECTEDTIME_KEY, this.getDate(fatFairyLastCollectedTime));
        this.setContent(obj, OPTIONFAIRYVIDEOON_KEY, optionFairyVideoOn);
        this.setContent(obj, FIRSTSESSIONLASTCOLLECTEDTIME_KEY, this.getDate(firstSessionLastCollectedTime));

        return obj;
    }
}
