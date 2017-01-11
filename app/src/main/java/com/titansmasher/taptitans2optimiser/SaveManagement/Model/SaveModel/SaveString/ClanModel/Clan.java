package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 16/11/2016.
 */

public class Clan extends SaveAbstract<JSONObject> {
    private static String CLANID_KEY = "clanID";
    private static String CLANICONID_KEY = "clanIconID";
    private static String NAME_KEY = "name";
    private static String DESCRIPTION_KEY = "description";
    private static String SCORE_KEY = "score";
    private static String RANK_KEY = "rank";
    private static String LEADERNAME_KEY = "leaderName";
    private static String COUNTRYCODE_KEY = "countryCode";
    private static String ISPRIVATECLAN_KEY = "isPrivateClan";
    private static String PASSCODE_KEY = "passCode";
    private static String STAGEREQUIREMENT_KEY = "stageRequirement";
    private static String DUNGEONTOTALCONTRIBUTIONS_KEY = "dungeonTotalContributions";
    private static String DUNGEONREQUIREDAMOUNT_KEY = "dungeonRequiredAmount";
    private static String DUNGEONNEXTBONUS_KEY = "dungeonNextBonus";
    private static String DUNGEONBONUS_KEY = "dungeonBonus";
    private static String LASTINFOUPDATEDTIMESTAMP_KEY = "lastInfoUpdatedTimestamp";
    private static String LASTMEMBERLISTUPDATEDTIMESTAMP_KEY = "lastMemberListUpdatedTimestamp";
    public String clanID;
    public String clanIconID;
    public String clanName;
    public String description;
    public Double score;
    public Integer rank;
    public String leaderName;
    public String countryCode;
    public Boolean isPrivateClan;
    public String passCode;
    public Integer stageRequirement;
    public Integer dungeonTotalContributions;
    public Integer dungeonRequiredAmount;
    public Integer dungeonNextBonus;
    public Integer dungeonBonus;
    public Date lastInfoUpdatedTimeStamp;
    public Date lastMemberListUpdatedTimestamp;

    public Clan() {
        super();
    }

    public Clan(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        clanID = "";
        clanIconID = "";
        clanName = "";
        description = "";
        score = 0d;
        rank = 0;
        leaderName = "";
        countryCode = "";
        isPrivateClan = false;
        passCode = "";
        stageRequirement = 0;
        dungeonTotalContributions = 0;
        dungeonRequiredAmount = 0;
        dungeonNextBonus = 0;
        dungeonBonus = 0;
        lastInfoUpdatedTimeStamp = new Date(0);
        lastMemberListUpdatedTimestamp = new Date(0);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        clanID = JSONHelpers.getStringSafe(obj, CLANID_KEY);
        clanIconID = JSONHelpers.getStringSafe(obj, CLANICONID_KEY);
        clanName = JSONHelpers.getStringSafe(obj, NAME_KEY);
        description = JSONHelpers.getStringSafe(obj, DESCRIPTION_KEY);
        score = JSONHelpers.getDoubleSafe(obj, SCORE_KEY);
        rank = JSONHelpers.getIntegerSafe(obj, RANK_KEY);
        leaderName = JSONHelpers.getStringSafe(obj, LEADERNAME_KEY);
        countryCode = JSONHelpers.getStringSafe(obj, COUNTRYCODE_KEY);
        isPrivateClan = JSONHelpers.getBooleanSafe(obj, ISPRIVATECLAN_KEY, false);
        passCode = JSONHelpers.getStringSafe(obj, PASSCODE_KEY);
        stageRequirement = JSONHelpers.getIntegerSafe(obj, STAGEREQUIREMENT_KEY);
        dungeonTotalContributions = JSONHelpers.getIntegerSafe(obj, DUNGEONTOTALCONTRIBUTIONS_KEY);
        dungeonRequiredAmount = JSONHelpers.getIntegerSafe(obj, DUNGEONREQUIREDAMOUNT_KEY);
        dungeonNextBonus = JSONHelpers.getIntegerSafe(obj, DUNGEONNEXTBONUS_KEY);
        dungeonBonus = JSONHelpers.getIntegerSafe(obj, DUNGEONBONUS_KEY);
        lastInfoUpdatedTimeStamp = getDate(JSONHelpers.getStringSafe(obj, LASTINFOUPDATEDTIMESTAMP_KEY));
        lastMemberListUpdatedTimestamp = getDate(JSONHelpers.getStringSafe(obj, LASTMEMBERLISTUPDATEDTIMESTAMP_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, CLANID_KEY, clanID);
        JSONHelpers.putSafe(obj, CLANICONID_KEY, clanIconID);
        JSONHelpers.putSafe(obj, NAME_KEY, clanName);
        JSONHelpers.putSafe(obj, DESCRIPTION_KEY, description);
        JSONHelpers.putSafe(obj, SCORE_KEY, score);
        JSONHelpers.putSafe(obj, RANK_KEY, rank);
        JSONHelpers.putSafe(obj, LEADERNAME_KEY, leaderName);
        JSONHelpers.putSafe(obj, COUNTRYCODE_KEY, countryCode);
        JSONHelpers.putSafe(obj, ISPRIVATECLAN_KEY, isPrivateClan);
        JSONHelpers.putSafe(obj, PASSCODE_KEY, passCode);
        JSONHelpers.putSafe(obj, STAGEREQUIREMENT_KEY, stageRequirement);
        JSONHelpers.putSafe(obj, DUNGEONTOTALCONTRIBUTIONS_KEY, dungeonTotalContributions);
        JSONHelpers.putSafe(obj, DUNGEONREQUIREDAMOUNT_KEY, dungeonRequiredAmount);
        JSONHelpers.putSafe(obj, DUNGEONNEXTBONUS_KEY, dungeonNextBonus);
        JSONHelpers.putSafe(obj, DUNGEONBONUS_KEY, dungeonBonus);
        JSONHelpers.putSafe(obj, LASTINFOUPDATEDTIMESTAMP_KEY, getDate(lastInfoUpdatedTimeStamp));
        JSONHelpers.putSafe(obj, LASTMEMBERLISTUPDATEDTIMESTAMP_KEY, getDate(lastMemberListUpdatedTimestamp));

        return obj;
    }
}
