package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel.ClanMembers;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 16/11/2016.
 */

public class ClanMember extends SaveAbstract<JSONObject> {
    private static String PLAYERID_KEY = "playerID";
    private static String PLAYERNAME_KEY = "playerName";
    private static String HIGHESTPETID_KEY = "highestPetID";
    private static String CURRENTSTAGE_KEY = "currentStage";
    private static String STAGECOUNT_KEY = "stageCount";
    private static String SCORE_KEY = "score";
    private static String TOTALQUESTCOUNT_KEY = "totalQuestCount";
    private static String WEEKLYQUESTCOUNT_KEY = "weeklyQuestCount";
    private static String RANK_KEY = "rank";
    private static String ARTIFACTCOUNT_KEY = "artifactCount";
    private static String CLANNAME_KEY = "clanName";
    private static String CLANICONID_KEY = "clanIconID";
    private static String CLANROLE_KEY = "clanRole";
    private static String TOTALTOURNAMENTSCOUNT_KEY = "totalTournamentsCount";
    private static String HIGHESTTOURNAMENTRANK_KEY = "highestTournamentRank";
    private static String COUNTRYCODE_KEY = "countryCode";
    private static String LASTINFOUPDATEDTIMESTAMP_KEY = "lastInfoUpdatedTimestamp";
    private static String EQUIPMENT_KEY = "equipment";
    public String playerID;
    public String playerName;
    public String highestPetID;
    public Integer currentStage;
    public Integer stageCount;
    public Integer score;
    public Integer totalQuestCount;
    public Integer weeklyQuestCount;
    public Integer rank;
    public Integer artifactCount;
    public String clanName;
    public String clanIconID;
    public String clanRole;
    public Integer totalTournamentCount;
    public Integer highestTournamentRank;
    public String countryCode;
    public Date lastInfoUpdatedTimestamp;
    public PlayerEquipment equipment;

    public ClanMember() {
        super();
    }

    public ClanMember(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        playerID = "";
        playerName = "";
        highestPetID = "Pet1";
        currentStage = 0;
        stageCount = 0;
        score = 0;
        totalQuestCount = 0;
        weeklyQuestCount = 0;
        rank = 0;
        artifactCount = 0;
        clanName = "";
        clanIconID = "";
        clanRole = "";
        totalTournamentCount = 0;
        highestTournamentRank = 0;
        countryCode = "";
        lastInfoUpdatedTimestamp = new Date(0);
        equipment = new PlayerEquipment();
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        playerID = JSONHelpers.getStringSafe(obj, PLAYERID_KEY);
        playerName = JSONHelpers.getStringSafe(obj, PLAYERNAME_KEY);
        highestPetID = JSONHelpers.getStringSafe(obj, HIGHESTPETID_KEY);
        currentStage = JSONHelpers.getIntegerSafe(obj, CURRENTSTAGE_KEY);
        stageCount = JSONHelpers.getIntegerSafe(obj, STAGECOUNT_KEY);
        score = JSONHelpers.getIntegerSafe(obj, SCORE_KEY);
        totalQuestCount = JSONHelpers.getIntegerSafe(obj, TOTALQUESTCOUNT_KEY);
        weeklyQuestCount = JSONHelpers.getIntegerSafe(obj, WEEKLYQUESTCOUNT_KEY);
        rank = JSONHelpers.getIntegerSafe(obj, RANK_KEY);
        artifactCount = JSONHelpers.getIntegerSafe(obj, ARTIFACTCOUNT_KEY);
        clanName = JSONHelpers.getStringSafe(obj, CLANNAME_KEY);
        clanIconID = JSONHelpers.getStringSafe(obj, CLANICONID_KEY);
        clanRole = JSONHelpers.getStringSafe(obj, CLANROLE_KEY);
        totalTournamentCount = JSONHelpers.getIntegerSafe(obj, TOTALTOURNAMENTSCOUNT_KEY);
        highestTournamentRank = JSONHelpers.getIntegerSafe(obj, HIGHESTTOURNAMENTRANK_KEY);
        countryCode = JSONHelpers.getStringSafe(obj, COUNTRYCODE_KEY);
        lastInfoUpdatedTimestamp = getDate(JSONHelpers.getStringSafe(obj, LASTINFOUPDATEDTIMESTAMP_KEY));
        equipment = new PlayerEquipment(JSONHelpers.getJSONObjectSafe(obj, EQUIPMENT_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, PLAYERID_KEY, playerID);
        JSONHelpers.putSafe(obj, PLAYERNAME_KEY, playerName);
        JSONHelpers.putSafe(obj, HIGHESTPETID_KEY, highestPetID);
        JSONHelpers.putSafe(obj, CURRENTSTAGE_KEY, currentStage);
        JSONHelpers.putSafe(obj, STAGECOUNT_KEY, stageCount);
        JSONHelpers.putSafe(obj, SCORE_KEY, score);
        JSONHelpers.putSafe(obj, TOTALQUESTCOUNT_KEY, totalQuestCount);
        JSONHelpers.putSafe(obj, WEEKLYQUESTCOUNT_KEY, weeklyQuestCount);
        JSONHelpers.putSafe(obj, RANK_KEY, rank);
        JSONHelpers.putSafe(obj, ARTIFACTCOUNT_KEY, artifactCount);
        JSONHelpers.putSafe(obj, CLANNAME_KEY, clanName);
        JSONHelpers.putSafe(obj, CLANICONID_KEY, clanIconID);
        JSONHelpers.putSafe(obj, CLANROLE_KEY, clanRole);
        JSONHelpers.putSafe(obj, TOTALTOURNAMENTSCOUNT_KEY, totalTournamentCount);
        JSONHelpers.putSafe(obj, HIGHESTTOURNAMENTRANK_KEY, highestTournamentRank);
        JSONHelpers.putSafe(obj, COUNTRYCODE_KEY, countryCode);
        JSONHelpers.putSafe(obj, LASTINFOUPDATEDTIMESTAMP_KEY, getDate(lastInfoUpdatedTimestamp));
        JSONHelpers.putSafe(obj, EQUIPMENT_KEY, equipment.getJson());

        return obj;
    }
}
