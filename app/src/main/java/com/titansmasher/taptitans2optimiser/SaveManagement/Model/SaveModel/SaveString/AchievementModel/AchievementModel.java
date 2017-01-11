package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AchievementModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 15/11/2016.
 */

public class AchievementModel extends SaveAbstract<JSONObject> {
    private static String MONSTERKILL_KEY = "MonsterKill";
    private static String COLLECTGOLD_KEY = "CollectGold";
    private static String UNLOCKHEROES_KEY = "UnlockHeroes";
    private static String REACHSTAGE_KEY = "ReachStage";
    private static String COLLECTRELICS_KEY = "CollectRelics";
    private static String OWNARTIFACTS_KEY = "OwnArtifacts";
    private static String HELPERDPS_KEY = "HelperDPS";
    private static String BOSSKILL_KEY = "BossKill";
    private static String TAPCOUNT_KEY = "TapCount";
    private static String PRESTIGECOUNT_KEY = "PrestigeCount";
    private static String HELPERLEVELS_KEY = "HelperLevels";
    private static String CHESTERSON_KEY = "Chesterson";
    private static String FAIRYCOUNT_KEY = "FairyCount";
    private static String JUMPATTACKCOUNT_KEY = "JumpAttackCount";
    private static String CRITICALCOUNT_KEY = "CriticalCount";
    private static String PARTICIPATEDTOURNAMENT_KEY = "ParticipatedTournament";
    private static String PETLEVEL_KEY = "PetLevel";
    private static String EQUIPMENTCOLLECTED_KEY = "EquipmentCollected";
    private static String TOTALSKILLPOINTS_KEY = "TotalSkillPoints";
    private static String MANNY_KEY = "Manny";
    private static String WEAPONS_KEY = "Weapons";
    private static String PERK_KEY = "Perk";
    private static String DOOMCOUNT_KEY = "doomCount";
    private static String PERKCOUNTRAIN_KEY = "perkCountRain";
    private static String PERKCOUNTMANA_KEY = "perkCountMana";
    private static String TWITTERFOLLOW_KEY = "twitterFollow";
    private static String FACEBOOKLIKE_KEY = "facebookLike";
    public AchievementData monsterKill;
    public AchievementData collectGold;
    public AchievementData unlockHeroes;
    public AchievementData reachStage;
    public AchievementData collectRelics;
    public AchievementData ownArtifacts;
    public AchievementData helperDPS;
    public AchievementData bossKill;
    public AchievementData tapCount;
    public AchievementData prestigeCount;
    public AchievementData helperLevels;
    public AchievementData chesterson;
    public AchievementData fairyCount;
    public AchievementData jumpAttackCount;
    public AchievementData criticalCount;
    public AchievementData participatedTournament;
    public AchievementData petLevel;
    public AchievementData equipmentCollected;
    public AchievementData totalSkillPoints;
    public AchievementData manny;
    public AchievementData weapons;
    public AchievementData perk;
    public Integer doomCount;
    public Integer perkCountRain;
    public Integer perkCountMana;
    public Boolean twitterFollow;
    public Boolean facebookLike;

    public AchievementModel(JSONObject obj) {
        super(obj);
    }

    public AchievementModel() {
        super();
    }

    @Override
    protected void populateFromNull() {
        monsterKill = new AchievementData(MONSTERKILL_KEY);
        collectGold = new AchievementData(COLLECTGOLD_KEY);
        unlockHeroes = new AchievementData(UNLOCKHEROES_KEY);
        reachStage = new AchievementData(REACHSTAGE_KEY);
        collectRelics = new AchievementData(COLLECTRELICS_KEY);
        ownArtifacts = new AchievementData(OWNARTIFACTS_KEY);
        helperDPS = new AchievementData(HELPERDPS_KEY);
        bossKill = new AchievementData(BOSSKILL_KEY);
        tapCount = new AchievementData(TAPCOUNT_KEY);
        prestigeCount = new AchievementData(PRESTIGECOUNT_KEY);
        helperLevels = new AchievementData(HELPERLEVELS_KEY);
        chesterson = new AchievementData(CHESTERSON_KEY);
        fairyCount = new AchievementData(FAIRYCOUNT_KEY);
        jumpAttackCount = new AchievementData(JUMPATTACKCOUNT_KEY);
        criticalCount = new AchievementData(CRITICALCOUNT_KEY);
        participatedTournament = new AchievementData(PARTICIPATEDTOURNAMENT_KEY);
        petLevel = new AchievementData(PETLEVEL_KEY);
        equipmentCollected = new AchievementData(EQUIPMENTCOLLECTED_KEY);
        totalSkillPoints = new AchievementData(TOTALSKILLPOINTS_KEY);
        manny = new AchievementData(MANNY_KEY);
        weapons = new AchievementData(WEAPONS_KEY);
        perk = new AchievementData(PERK_KEY);
        doomCount = 0;
        perkCountRain = 0;
        perkCountMana = 0;
        twitterFollow = false;
        facebookLike = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        monsterKill = new AchievementData(obj, MONSTERKILL_KEY);
        collectGold = new AchievementData(obj, COLLECTGOLD_KEY);
        unlockHeroes = new AchievementData(obj, UNLOCKHEROES_KEY);
        reachStage = new AchievementData(obj, REACHSTAGE_KEY);
        collectRelics = new AchievementData(obj, COLLECTRELICS_KEY);
        ownArtifacts = new AchievementData(obj, OWNARTIFACTS_KEY);
        helperDPS = new AchievementData(obj, HELPERDPS_KEY);
        bossKill = new AchievementData(obj, BOSSKILL_KEY);
        tapCount = new AchievementData(obj, TAPCOUNT_KEY);
        prestigeCount = new AchievementData(obj, PRESTIGECOUNT_KEY);
        helperLevels = new AchievementData(obj, HELPERLEVELS_KEY);
        chesterson = new AchievementData(obj, CHESTERSON_KEY);
        fairyCount = new AchievementData(obj, FAIRYCOUNT_KEY);
        jumpAttackCount = new AchievementData(obj, JUMPATTACKCOUNT_KEY);
        criticalCount = new AchievementData(obj, CRITICALCOUNT_KEY);
        participatedTournament = new AchievementData(obj, PARTICIPATEDTOURNAMENT_KEY);
        petLevel = new AchievementData(obj, PETLEVEL_KEY);
        equipmentCollected = new AchievementData(obj, EQUIPMENTCOLLECTED_KEY);
        totalSkillPoints = new AchievementData(obj, TOTALSKILLPOINTS_KEY);
        manny = new AchievementData(obj, MANNY_KEY);
        weapons = new AchievementData(obj, WEAPONS_KEY);
        perk = new AchievementData(obj, PERK_KEY);
        doomCount = getIntegerContent(obj, DOOMCOUNT_KEY);
        perkCountRain = getIntegerContent(obj, PERKCOUNTRAIN_KEY);
        perkCountMana = getIntegerContent(obj, PERKCOUNTMANA_KEY);
        twitterFollow = getBooleanContent(obj, TWITTERFOLLOW_KEY, false);
        facebookLike = getBooleanContent(obj, FACEBOOKLIKE_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        monsterKill.addJson(obj);
        collectGold.addJson(obj);
        unlockHeroes.addJson(obj);
        reachStage.addJson(obj);
        collectRelics.addJson(obj);
        ownArtifacts.addJson(obj);
        helperDPS.addJson(obj);
        bossKill.addJson(obj);
        tapCount.addJson(obj);
        prestigeCount.addJson(obj);
        helperLevels.addJson(obj);
        chesterson.addJson(obj);
        fairyCount.addJson(obj);
        jumpAttackCount.addJson(obj);
        criticalCount.addJson(obj);
        participatedTournament.addJson(obj);
        petLevel.addJson(obj);
        equipmentCollected.addJson(obj);
        totalSkillPoints.addJson(obj);
        manny.addJson(obj);
        weapons.addJson(obj);
        perk.addJson(obj);
        setContent(obj, DOOMCOUNT_KEY, doomCount);
        setContent(obj, PERKCOUNTRAIN_KEY, perkCountRain);
        setContent(obj, PERKCOUNTMANA_KEY, perkCountMana);
        setContent(obj, TWITTERFOLLOW_KEY, twitterFollow);
        setContent(obj, FACEBOOKLIKE_KEY, facebookLike);

        return obj;
    }
}
