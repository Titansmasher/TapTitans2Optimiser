package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 03/01/2017.
 */

public class StageLogicController extends SaveAbstract<JSONObject> {

    private static String CURRENTSTAGE_KEY = "currentStage";
    private static String AUTOADVANCE_KEY = "autoAdvance";
    private static String ENEMYKILLCOUNT_KEY = "enemyKillCount";
    private static String BOSSDEFEATED_KEY = "bossDefeated";
    public Integer currentStage;
    public Boolean autoAdvance;
    public Integer enemyKillCount;
    public Boolean bossDefeated;

    public StageLogicController() {
        super();
    }

    public StageLogicController(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        currentStage = 0;
        autoAdvance = false;
        enemyKillCount = 0;
        bossDefeated = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentStage = this.getIntegerContent(obj, CURRENTSTAGE_KEY);
        autoAdvance = this.getBooleanContent(obj, AUTOADVANCE_KEY, false);
        enemyKillCount = this.getIntegerContent(obj, ENEMYKILLCOUNT_KEY);
        bossDefeated = this.getBooleanContent(obj, BOSSDEFEATED_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, CURRENTSTAGE_KEY, currentStage);
        this.setContent(obj, AUTOADVANCE_KEY, autoAdvance);
        this.setContent(obj, ENEMYKILLCOUNT_KEY, enemyKillCount);
        this.setContent(obj, BOSSDEFEATED_KEY, bossDefeated);

        return obj;
    }
}
