package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 02/01/2017.
 */

public class PlayerModel extends SaveAbstract<JSONObject> {

    private static String GOLD_KEY = "gold";
    private static String MANAPOTIONSPENT_KEY = "manaPotionSpent";
    private static String MANAPOTIONRECIEVEDLOCAL_KEY = "manaPotionRecievedLocal";
    private static String MANAPOTIONRECIEVEDSERVER_KEY = "manaPotionRecievedServer";
    private static String RELICSSPENTSERVER_KEY = "relicsSpentServer";
    private static String RELICSRECEIVEDSERVER_KEY = "relicsReceivedServer";
    private static String LEVEL_KEY = "level";
    private static String BASEDAMAGE_KEY = "baseDamage";
    private static String CURRENTMANA_KEY = "currentMana";
    private static String MANAPOTIONTIMER_KEY = "manaPotionTimer";
    private static String DSLO_KEY = "dsLo";
    private static String DSSE_KEY = "dsSe";
    private static String DRLO_KEY = "drLo";
    private static String DRAC_KEY = "drAc";
    private static String DRFA_KEY = "drFa";
    private static String DRSE_KEY = "drSe";
    private static String SKILLPOINTSRECEIVEDSERVER_KEY = "skillPointsReceivedServer";
    private static String SKILLPOINTSSPENTSERVER_KEY = "skillPointsSpentServer";
    private static String LASTSKILLPOINTSCOLLECTEDSTAGE_KEY = "lastSkillPointsCollectedStage";
    private static String LASTVIEWEDDIALOGUE_KEY = "lastViewedDialogue";
    private static String DPSLOSTTOPRESTIGE_KEY = "dpsLostToPrestige";
    private static String GOLDLOSTTOPRESTIGE_KEY = "goldLostToPrestige";
    private static String GOLDSINCEPRESTIGE_KEY = "goldSincePrestige";
    private static String HASRATEDGAME_KEY = "hasRatedGame";
    private static String REPORTEDPLAYERS_KEY = "reportedPlayers";
    private static String HOLIDAYBUNDLEEMAIL_KEY = "holidayBundleEmail";
    public Double gold;
    public Integer manaPotionSpent;
    public Integer manaPotionRecievedLocal;
    public Integer manaPotionRecievedServer;
    public Double relicsSpentServer;
    public Double relicsRecievedServer;
    public Integer level;
    public Double baseDamage;
    public Double currentMana;
    public Float manaPotionTimer;
    public Integer dsLo;
    public Integer dsSe;
    public Integer drLo;
    public Integer drAc;
    public Integer drFa;
    public Integer drSe;
    public Integer skillPointsRecievedServer;
    public Integer skillPointsSpentServer;
    public Integer lastSkillPointsCollectedStage;
    public Date lastViewedDialogue;
    public Double dpsLostToPrestige;
    public Double goldLostToPrestige;
    public Double goldSincePrestige;
    public Boolean hasRatedGame;
    public SaveList<String> reportedPlayers;
    public String holidayBundleEmail;

    public PlayerModel() {
        super();
    }

    public PlayerModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        reportedPlayers = new SaveList<String>() {
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
        gold = 0d;
        manaPotionSpent = 0;
        manaPotionRecievedLocal = 0;
        manaPotionRecievedServer = 0;
        relicsSpentServer = 0d;
        relicsRecievedServer = 0d;
        level = 0;
        baseDamage = 0d;
        currentMana = 0d;
        manaPotionTimer = 0f;
        dsLo = 0;
        dsSe = 0;
        drLo = 0;
        drAc = 0;
        drFa = 0;
        drSe = 0;
        skillPointsRecievedServer = 0;
        skillPointsSpentServer = 0;
        lastSkillPointsCollectedStage = 0;
        lastViewedDialogue = new Date(0);
        dpsLostToPrestige = 0d;
        goldLostToPrestige = 0d;
        goldSincePrestige = 0d;
        hasRatedGame = false;
        reportedPlayers.setJson(null);
        holidayBundleEmail = "";
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        gold = this.getDoubleContent(obj, GOLD_KEY);
        manaPotionSpent = this.getIntegerContent(obj, MANAPOTIONSPENT_KEY);
        manaPotionRecievedLocal = this.getIntegerContent(obj, MANAPOTIONRECIEVEDLOCAL_KEY);
        manaPotionRecievedServer = this.getIntegerContent(obj, MANAPOTIONRECIEVEDSERVER_KEY);
        relicsSpentServer = this.getDoubleContent(obj, RELICSSPENTSERVER_KEY);
        relicsRecievedServer = this.getDoubleContent(obj, RELICSRECEIVEDSERVER_KEY);
        level = this.getIntegerContent(obj, LEVEL_KEY);
        baseDamage = this.getDoubleContent(obj, BASEDAMAGE_KEY);
        currentMana = this.getDoubleContent(obj, CURRENTMANA_KEY);
        manaPotionTimer = this.getFloatContent(obj, MANAPOTIONTIMER_KEY);
        dsLo = this.getIntegerContent(obj, DSLO_KEY);
        dsSe = this.getIntegerContent(obj, DSSE_KEY);
        drLo = this.getIntegerContent(obj, DRLO_KEY);
        drAc = this.getIntegerContent(obj, DRAC_KEY);
        drFa = this.getIntegerContent(obj, DRFA_KEY);
        drSe = this.getIntegerContent(obj, DRSE_KEY);
        skillPointsRecievedServer = this.getIntegerContent(obj, SKILLPOINTSRECEIVEDSERVER_KEY);
        skillPointsSpentServer = this.getIntegerContent(obj, SKILLPOINTSSPENTSERVER_KEY);
        lastSkillPointsCollectedStage = this.getIntegerContent(obj, LASTSKILLPOINTSCOLLECTEDSTAGE_KEY);
        lastViewedDialogue = this.getDate(this.getStringContent(obj, LASTVIEWEDDIALOGUE_KEY));
        dpsLostToPrestige = this.getDoubleContent(obj, DPSLOSTTOPRESTIGE_KEY);
        goldLostToPrestige = this.getDoubleContent(obj, GOLDLOSTTOPRESTIGE_KEY);
        goldSincePrestige = this.getDoubleContent(obj, GOLDSINCEPRESTIGE_KEY);
        hasRatedGame = this.getBooleanContent(obj, HASRATEDGAME_KEY, false);
        reportedPlayers.setJson(this.getJSONArrayContent(obj, REPORTEDPLAYERS_KEY));
        holidayBundleEmail = this.getStringContent(obj, HOLIDAYBUNDLEEMAIL_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, GOLD_KEY, gold);
        this.setContent(obj, MANAPOTIONSPENT_KEY, manaPotionSpent);
        this.setContent(obj, MANAPOTIONRECIEVEDLOCAL_KEY, manaPotionRecievedLocal);
        this.setContent(obj, MANAPOTIONRECIEVEDSERVER_KEY, manaPotionRecievedServer);
        this.setContent(obj, RELICSSPENTSERVER_KEY, relicsSpentServer);
        this.setContent(obj, RELICSRECEIVEDSERVER_KEY, relicsRecievedServer);
        this.setContent(obj, LEVEL_KEY, level);
        this.setContent(obj, BASEDAMAGE_KEY, baseDamage);
        this.setContent(obj, CURRENTMANA_KEY, currentMana);
        this.setContent(obj, MANAPOTIONTIMER_KEY, manaPotionTimer);
        this.setContent(obj, DSLO_KEY, dsLo);
        this.setContent(obj, DSSE_KEY, dsSe);
        this.setContent(obj, DRLO_KEY, drLo);
        this.setContent(obj, DRAC_KEY, drAc);
        this.setContent(obj, DRFA_KEY, drFa);
        this.setContent(obj, DRSE_KEY, drSe);
        this.setContent(obj, SKILLPOINTSRECEIVEDSERVER_KEY, skillPointsRecievedServer);
        this.setContent(obj, SKILLPOINTSSPENTSERVER_KEY, skillPointsSpentServer);
        this.setContent(obj, LASTSKILLPOINTSCOLLECTEDSTAGE_KEY, lastSkillPointsCollectedStage);
        this.setContent(obj, LASTVIEWEDDIALOGUE_KEY, this.getDate(lastViewedDialogue));
        this.setContent(obj, DPSLOSTTOPRESTIGE_KEY, dpsLostToPrestige);
        this.setContent(obj, GOLDLOSTTOPRESTIGE_KEY, goldLostToPrestige);
        this.setContent(obj, GOLDSINCEPRESTIGE_KEY, goldSincePrestige);
        this.setContent(obj, HASRATEDGAME_KEY, hasRatedGame);
        this.setContent(obj, REPORTEDPLAYERS_KEY, reportedPlayers.getJson());
        this.setContent(obj, HOLIDAYBUNDLEEMAIL_KEY, holidayBundleEmail);

        return obj;
    }
}
