package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AccountModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AchievementModel.AchievementModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ActiveSkillModel.ActiveSkillModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AnalyticsModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ArtifactModel.ArtifactModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.AvatarModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.BackgroundModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel.ClanModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanShipController.ClanShipController;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.DailyRewardModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.EquipmentModel.EquipmentModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.FairyController;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.GHTime;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.GameModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.HelperModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.HelperWeaponController;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.InactiveGameplayModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.LocalizationModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.OptionsController;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.PerkModel.PerkModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.PetModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.PlayerModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.SkillTreeModel;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.StageLogicController;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel.TournamentModel;

import org.json.JSONObject;

/**
 * Created by Danny on 14/11/2016.
 */

public class SaveStringModel extends SaveAbstract<JSONObject> {
    private static String ACCOUNTMODEL_KEY = "AccountModel";
    private static String ACHIEVEMENTMODEL_KEY = "AchievementModel";
    private static String ACTIVESKILLMODEL_KEY = "ActiveSkillModel";
    private static String ANALYTICSMODEL_KEY = "AnalyticsModel";
    private static String AVATARMODEL_KEY = "AvatarModel";
    private static String ARTIFACTMODEL_KEY = "ArtifactModel";
    private static String BACKGROUNDMODEL_KEY = "BackgroundModel";
    private static String CLANMODEL_KEY = "ClanModel";
    private static String CLANSHIPCONTROLLER_KEY = "ClanShipController";
    private static String DAILYREWARDMODEL_KEY = "DailyRewardModel";
    private static String EQUIPMENTMODEL_KEY = "EquipmentModel";
    private static String FAIRYCONTROLLER_KEY = "FairyController";
    private static String GHTIME_KEY = "GHTime";
    private static String GAMEMODEL_KEY = "GameModel";
    private static String HELPERWEAPONCONTROLLER_KEY = "HelperWeaponController";
    private static String HELPERMODEL_KEY = "HelperModel";
    private static String INACTIVEGAMEPLAYMODEL_KEY = "InactiveGameplayModel";
    private static String LOCALIZATIONMODEL_KEY = "LocalizationModel";
    private static String OPTIONSCONTROLLER_KEY = "OptionsController";
    private static String PERKMODEL_KEY = "PerkModel";
    private static String PETMODEL_KEY = "PetModel";
    private static String PLAYERMODEL_KEY = "PlayerModel";
    private static String SKILLTREEMODEL_KEY = "SkillTreeModel";
    private static String STAGELOGICCONTROLLER_KEY = "StageLogicController";
    private static String TOURNAMENTMODEL_KEY = "TournamentModel";
    public AccountModel accountModel;
    public AchievementModel achievementModel;
    public ActiveSkillModel activeSkillModel;
    public AnalyticsModel analyticsModel;
    public ArtifactModel artifactModel;
    public AvatarModel avatarModel;
    public BackgroundModel backgroundModel;
    public ClanModel clanModel;
    public ClanShipController clanShipController;
    public DailyRewardModel dailyRewardModel;
    public EquipmentModel equipmentModel;
    public FairyController fairyController;
    public GHTime ghTime;
    public GameModel gameModel;
    public HelperWeaponController helperWeaponController;
    public HelperModel helperModel;
    public InactiveGameplayModel inactiveGameplayModel;
    public LocalizationModel localizationModel;
    public OptionsController optionsController;
    public PerkModel perkModel;
    public PetModel petModel;
    public PlayerModel playerModel;
    public SkillTreeModel skillTreeModel;
    public StageLogicController stageLogicController;
    public TournamentModel tournamentModel;

    public SaveStringModel() {
        super();
    }

    public SaveStringModel(JSONObject obj) {
        super(obj);
    }

    @Override
    public void populateFromNull() {
        accountModel = new AccountModel();
        achievementModel = new AchievementModel();
        activeSkillModel = new ActiveSkillModel();
        analyticsModel = new AnalyticsModel();
        artifactModel = new ArtifactModel();
        avatarModel = new AvatarModel();
        backgroundModel = new BackgroundModel();
        clanModel = new ClanModel();
        clanShipController = new ClanShipController();
        dailyRewardModel = new DailyRewardModel();
        equipmentModel = new EquipmentModel();
        fairyController = new FairyController();
        ghTime = new GHTime();
        gameModel = new GameModel();
        helperWeaponController = new HelperWeaponController();
        helperModel = new HelperModel();
        inactiveGameplayModel = new InactiveGameplayModel();
        localizationModel = new LocalizationModel();
        optionsController = new OptionsController();
        perkModel = new PerkModel();
        petModel = new PetModel();
        playerModel = new PlayerModel();
        skillTreeModel = new SkillTreeModel();
        stageLogicController = new StageLogicController();
        tournamentModel = new TournamentModel();
    }

    @Override
    public void populateFromJson(JSONObject obj) {
        accountModel = new AccountModel(JSONHelpers.getJSONObjectSafe(obj, ACCOUNTMODEL_KEY));
        achievementModel = new AchievementModel(JSONHelpers.getJSONObjectSafe(obj, ACHIEVEMENTMODEL_KEY));
        activeSkillModel = new ActiveSkillModel(JSONHelpers.getJSONObjectSafe(obj, ACTIVESKILLMODEL_KEY));
        analyticsModel = new AnalyticsModel(JSONHelpers.getJSONObjectSafe(obj, ANALYTICSMODEL_KEY));
        artifactModel = new ArtifactModel(JSONHelpers.getJSONObjectSafe(obj, ARTIFACTMODEL_KEY));
        avatarModel = new AvatarModel(JSONHelpers.getJSONObjectSafe(obj, AVATARMODEL_KEY));
        backgroundModel = new BackgroundModel(JSONHelpers.getJSONObjectSafe(obj, BACKGROUNDMODEL_KEY));
        clanModel = new ClanModel(JSONHelpers.getJSONObjectSafe(obj, CLANMODEL_KEY));
        clanShipController = new ClanShipController(JSONHelpers.getJSONObjectSafe(obj, CLANSHIPCONTROLLER_KEY));
        dailyRewardModel = new DailyRewardModel(JSONHelpers.getJSONObjectSafe(obj, DAILYREWARDMODEL_KEY));
        equipmentModel = new EquipmentModel(JSONHelpers.getJSONObjectSafe(obj, EQUIPMENTMODEL_KEY));
        fairyController = new FairyController(JSONHelpers.getJSONObjectSafe(obj, FAIRYCONTROLLER_KEY));
        ghTime = new GHTime(JSONHelpers.getJSONObjectSafe(obj, GHTIME_KEY));
        gameModel = new GameModel(JSONHelpers.getJSONObjectSafe(obj, GAMEMODEL_KEY));
        helperWeaponController = new HelperWeaponController(JSONHelpers.getJSONObjectSafe(obj, HELPERWEAPONCONTROLLER_KEY));
        helperModel = new HelperModel(JSONHelpers.getJSONObjectSafe(obj, HELPERMODEL_KEY));
        inactiveGameplayModel = new InactiveGameplayModel(JSONHelpers.getJSONObjectSafe(obj, INACTIVEGAMEPLAYMODEL_KEY));
        localizationModel = new LocalizationModel(JSONHelpers.getJSONObjectSafe(obj, LOCALIZATIONMODEL_KEY));
        optionsController = new OptionsController(JSONHelpers.getJSONObjectSafe(obj, OPTIONSCONTROLLER_KEY));
        perkModel = new PerkModel(JSONHelpers.getJSONObjectSafe(obj, PERKMODEL_KEY));
        petModel = new PetModel(JSONHelpers.getJSONObjectSafe(obj, PETMODEL_KEY));
        playerModel = new PlayerModel(JSONHelpers.getJSONObjectSafe(obj, PLAYERMODEL_KEY));
        skillTreeModel = new SkillTreeModel(JSONHelpers.getJSONObjectSafe(obj, SKILLTREEMODEL_KEY));
        stageLogicController = new StageLogicController(JSONHelpers.getJSONObjectSafe(obj, STAGELOGICCONTROLLER_KEY));
        tournamentModel = new TournamentModel(JSONHelpers.getJSONObjectSafe(obj, TOURNAMENTMODEL_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, ACCOUNTMODEL_KEY, accountModel.getJson());
        JSONHelpers.putSafe(obj, ACHIEVEMENTMODEL_KEY, achievementModel.getJson());
        JSONHelpers.putSafe(obj, ACTIVESKILLMODEL_KEY, activeSkillModel.getJson());
        JSONHelpers.putSafe(obj, ANALYTICSMODEL_KEY, analyticsModel.getJson());
        JSONHelpers.putSafe(obj, ARTIFACTMODEL_KEY, artifactModel.getJson());
        JSONHelpers.putSafe(obj, AVATARMODEL_KEY, avatarModel.getJson());
        JSONHelpers.putSafe(obj, BACKGROUNDMODEL_KEY, backgroundModel.getJson());
        JSONHelpers.putSafe(obj, CLANMODEL_KEY, clanModel.getJson());
        JSONHelpers.putSafe(obj, CLANSHIPCONTROLLER_KEY, clanShipController.getJson());
        JSONHelpers.putSafe(obj, DAILYREWARDMODEL_KEY, dailyRewardModel.getJson());
        JSONHelpers.putSafe(obj, EQUIPMENTMODEL_KEY, equipmentModel.getJson());
        JSONHelpers.putSafe(obj, FAIRYCONTROLLER_KEY, fairyController.getJson());
        JSONHelpers.putSafe(obj, GHTIME_KEY, ghTime.getJson());
        JSONHelpers.putSafe(obj, GAMEMODEL_KEY, gameModel.getJson());
        JSONHelpers.putSafe(obj, HELPERWEAPONCONTROLLER_KEY, helperWeaponController.getJson());
        JSONHelpers.putSafe(obj, HELPERMODEL_KEY, helperModel.getJson());
        JSONHelpers.putSafe(obj, INACTIVEGAMEPLAYMODEL_KEY, inactiveGameplayModel.getJson());
        JSONHelpers.putSafe(obj, LOCALIZATIONMODEL_KEY, localizationModel.getJson());
        JSONHelpers.putSafe(obj, OPTIONSCONTROLLER_KEY, optionsController.getJson());
        JSONHelpers.putSafe(obj, PERKMODEL_KEY, perkModel.getJson());
        JSONHelpers.putSafe(obj, PETMODEL_KEY, petModel.getJson());
        JSONHelpers.putSafe(obj, PLAYERMODEL_KEY, playerModel.getJson());
        JSONHelpers.putSafe(obj, SKILLTREEMODEL_KEY, skillTreeModel.getJson());
        JSONHelpers.putSafe(obj, STAGELOGICCONTROLLER_KEY, stageLogicController.getJson());
        JSONHelpers.putSafe(obj, TOURNAMENTMODEL_KEY, tournamentModel.getJson());

        return obj;
    }
}
