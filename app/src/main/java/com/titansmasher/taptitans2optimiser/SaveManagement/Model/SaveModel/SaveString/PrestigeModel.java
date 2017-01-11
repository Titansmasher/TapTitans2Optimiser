package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 02/01/2017.
 */

public class PrestigeModel extends SaveAbstract<JSONObject> {

    private static String RELICDROP_KEY = "relicDrop";
    private static String MAXPRESTIGESTAGECOUNT_KEY = "maxPrestigeStageCount";
    private static String LASTPRESTIGETIME_KEY = "lastPrestigeTime";
    public Double relicDrop;
    public Integer maxPrestigeStageCount;
    public Date lastPrestigeTime;

    public PrestigeModel() {
        super();
    }

    public PrestigeModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        relicDrop = 0d;
        maxPrestigeStageCount = 0;
        lastPrestigeTime = new Date(0);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        relicDrop = this.getDoubleContent(obj, RELICDROP_KEY);
        maxPrestigeStageCount = this.getIntegerContent(obj, MAXPRESTIGESTAGECOUNT_KEY);
        lastPrestigeTime = this.getDate(this.getStringContent(obj, LASTPRESTIGETIME_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, RELICDROP_KEY, relicDrop);
        this.setContent(obj, MAXPRESTIGESTAGECOUNT_KEY, maxPrestigeStageCount);
        this.setContent(obj, LASTPRESTIGETIME_KEY, this.getDate(lastPrestigeTime));

        return obj;
    }
}
