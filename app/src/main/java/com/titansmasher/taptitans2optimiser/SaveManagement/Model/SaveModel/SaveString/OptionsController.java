package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class OptionsController extends SaveAbstract<JSONObject> {

    private static String OPTIONVOLUME_KEY = "optionVolume";
    private static String OPTIONMUSIC_KEY = "optionMusic";
    private static String OPTIONNOTIFICATIONS_KEY = "optionNotification";
    private static String UPGRADEAMOUNT_KEY = "upgradeAmount";
    private static String ROUNDEDUPGRADE_KEY = "roundedUpgrade";
    private static String SHOWSCIENTIFIC_KEY = "showScientific";
    public Integer optionVolume;
    public Integer optionMusic;
    public Boolean optionNotification;
    public Integer upgradeAmount;
    public Boolean roundedUpgrade;
    public Boolean showScientific;

    public OptionsController() {
        super();
    }

    public OptionsController(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        optionVolume = 0;
        optionMusic = 0;
        optionNotification = false;
        upgradeAmount = -1;
        roundedUpgrade = false;
        showScientific = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        optionVolume = this.getIntegerContent(obj, OPTIONVOLUME_KEY);
        optionMusic = this.getIntegerContent(obj, OPTIONMUSIC_KEY);
        optionNotification = this.getBooleanContent(obj, OPTIONNOTIFICATIONS_KEY, false);
        upgradeAmount = this.getIntegerContent(obj, UPGRADEAMOUNT_KEY);
        roundedUpgrade = this.getBooleanContent(obj, ROUNDEDUPGRADE_KEY, false);
        showScientific = this.getBooleanContent(obj, SHOWSCIENTIFIC_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, OPTIONVOLUME_KEY, optionVolume);
        this.setContent(obj, OPTIONMUSIC_KEY, optionMusic);
        this.setContent(obj, OPTIONNOTIFICATIONS_KEY, optionNotification);
        this.setContent(obj, UPGRADEAMOUNT_KEY, upgradeAmount);
        this.setContent(obj, ROUNDEDUPGRADE_KEY, roundedUpgrade);
        this.setContent(obj, SHOWSCIENTIFIC_KEY, showScientific);

        return obj;
    }
}
