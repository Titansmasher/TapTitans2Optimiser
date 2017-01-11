package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AchievementModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Enums.AchievementStatus;

import org.json.JSONObject;

/**
 * Created by Danny on 15/11/2016.
 */

public class AchievementData extends SaveAbstract<JSONObject> {
    public Integer teir;
    public AchievementStatus status;
    public Double progress;
    private String baseKey;

    private String PROGRESS_SUFFIX = "CryptoObj";
    private String STATUS_SUFFIX = "status";
    private String TEIR_SUFFIX = "tier";

    public AchievementData(JSONObject obj, String baseKey) {
        this.baseKey = baseKey;
        if (obj == null) {
            populateFromNull();
        } else {
            populateFromJson(obj);
        }
    }

    public AchievementData(String baseKey) {
        populateFromNull();
        this.baseKey = baseKey;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        this.progress = getDoubleContent(obj, baseKey + PROGRESS_SUFFIX);
        this.status = AchievementStatus.getFromString(getStringContent(obj, baseKey + STATUS_SUFFIX));
        this.teir = getIntegerContent(obj, baseKey + TEIR_SUFFIX);
    }

    @Override
    public JSONObject getJson() {
        return null;
    }

    @Override
    protected void populateFromNull() {
        this.progress = 0d;
        this.status = AchievementStatus.InProgress;
        this.teir = 0;
    }

    public void addJson(JSONObject obj) {
        setContent(obj, this.baseKey + PROGRESS_SUFFIX, this.progress);
        setContent(obj, this.baseKey + STATUS_SUFFIX, this.status.toString());
        setContent(obj, this.baseKey + TEIR_SUFFIX, this.teir);
    }
}
