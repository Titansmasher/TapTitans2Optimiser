package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 01/01/2017.
 */

public class DailyRewardModel extends SaveAbstract<JSONObject> {
    private static String DAILYREWARDDAYNUMBERLASTCOLLECTED_KEY = "dailyRewardDayNumberLastCollected";
    private static String DAILYREWARDDATELASTCOLLECTED_KEY = "dailyRewardDateLastCollected";
    public Integer dailyRewardDayNumberLastCollected;
    public Date dailyRewardDateLastCollected;

    public DailyRewardModel() {
        super();
    }

    public DailyRewardModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        dailyRewardDateLastCollected = new Date(0);
        dailyRewardDayNumberLastCollected = 0;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        dailyRewardDateLastCollected = getDate(this.getStringContent(obj, DAILYREWARDDATELASTCOLLECTED_KEY));
        dailyRewardDayNumberLastCollected = this.getIntegerContent(obj, DAILYREWARDDAYNUMBERLASTCOLLECTED_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, DAILYREWARDDATELASTCOLLECTED_KEY, getDate(dailyRewardDateLastCollected));
        this.setContent(obj, DAILYREWARDDAYNUMBERLASTCOLLECTED_KEY, dailyRewardDayNumberLastCollected);

        return obj;
    }
}
