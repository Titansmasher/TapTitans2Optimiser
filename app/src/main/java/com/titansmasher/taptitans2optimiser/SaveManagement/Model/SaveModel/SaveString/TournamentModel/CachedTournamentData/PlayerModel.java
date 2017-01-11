package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel.CachedTournamentData;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 04/01/2017.
 */

public class PlayerModel extends SaveAbstract<JSONObject> {

    private static String ARTIFACTS_KEY = "artifacts";
    private static String CLAN_ICON_KEY = "clan_icon";
    private static String CLAN_NAME_KEY = "clan_name";
    private static String COUNTRY_CODE_KEY = "country_code";
    private static String CURRENT_AVATAR_KEY = "current_avatar";
    private static String EQUIPMENT_KEY = "equipment";
    private static String HIGHEST_PET_ID_KEY = "highest_pet_id";
    private static String HIGHEST_TOURNAMENT_KEY = "highest_tournament";
    private static String MAX_STAGE_KEY = "max_stage";
    private static String NAME_KEY = "name";
    private static String PLAYER_CODE_KEY = "player_code";
    private static String RANK_KEY = "rank";
    private static String ROLE_KEY = "role";
    private static String STAGE_KEY = "stage";
    private static String TOTAL_CLAN_QUESTS_KEY = "total_clan_quests";
    private static String TOTAL_TOURNAMENTS_KEY = "total_tournaments";
    private static String WEEKLY_DUNGEON_COUNT_KEY = "weekly_dungeon_count";
    public Integer artifacts;
    public Integer clan_icon;
    public String clan_name;
    public String country_code;
    public String current_avatar;
    public SaveList<EquipmentLookup> equipment;
    public String highest_pet_id;
    public Integer highest_tournament;
    public Integer max_stage;
    public String name;
    public String player_code;
    public Long rank;
    public String role;
    public Integer stage;
    public Integer total_clan_quests;
    public Integer total_tournaments;
    public Integer weekly_dungeon_count;

    public PlayerModel() {
        super();
    }

    public PlayerModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        equipment = new SaveList<EquipmentLookup>() {
            @Override
            protected EquipmentLookup getObjectValue(Object obj) {
                return new EquipmentLookup((JSONObject) obj);
            }

            @Override
            protected Object getJsonValue(EquipmentLookup value) {
                return value.getJson();
            }
        };
    }

    @Override
    protected void populateFromNull() {
        artifacts = 0;
        clan_icon = 0;
        clan_name = "";
        country_code = "";
        current_avatar = "";
        equipment.setJson(null);
        highest_pet_id = "";
        highest_tournament = 0;
        max_stage = 0;
        name = "";
        player_code = "";
        rank = 0l;
        role = "";
        stage = 0;
        total_clan_quests = 0;
        total_tournaments = 0;
        weekly_dungeon_count = 0;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        artifacts = Integer.parseInt(this.getStringContent(obj, ARTIFACTS_KEY));
        clan_icon = Integer.parseInt(this.getStringContent(obj, CLAN_ICON_KEY));
        clan_name = this.getStringContent(obj, CLAN_NAME_KEY);
        country_code = this.getStringContent(obj, COUNTRY_CODE_KEY);
        current_avatar = this.getStringContent(obj, CURRENT_AVATAR_KEY);
        equipment.setJson(this.getJSONArrayContent(obj, EQUIPMENT_KEY));
        highest_pet_id = this.getStringContent(obj, HIGHEST_PET_ID_KEY);
        highest_tournament = Integer.parseInt(this.getStringContent(obj, HIGHEST_TOURNAMENT_KEY));
        max_stage = Integer.parseInt(this.getStringContent(obj, MAX_STAGE_KEY));
        name = this.getStringContent(obj, NAME_KEY);
        player_code = this.getStringContent(obj, PLAYER_CODE_KEY);
        rank = this.getLongContent(obj, RANK_KEY);
        role = this.getStringContent(obj, ROLE_KEY);
        stage = this.getIntegerContent(obj, STAGE_KEY);
        total_clan_quests = Integer.parseInt(this.getStringContent(obj, TOTAL_CLAN_QUESTS_KEY));
        total_tournaments = Integer.parseInt(this.getStringContent(obj, TOTAL_TOURNAMENTS_KEY));
        weekly_dungeon_count = Integer.parseInt(this.getStringContent(obj, WEEKLY_DUNGEON_COUNT_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, ARTIFACTS_KEY, artifacts.toString());
        this.setContent(obj, CLAN_ICON_KEY, clan_icon.toString());
        this.setContent(obj, CLAN_NAME_KEY, clan_name);
        this.setContent(obj, COUNTRY_CODE_KEY, country_code);
        this.setContent(obj, CURRENT_AVATAR_KEY, current_avatar);
        this.setContent(obj, EQUIPMENT_KEY, equipment.getJson());
        this.setContent(obj, HIGHEST_PET_ID_KEY, highest_pet_id);
        this.setContent(obj, HIGHEST_TOURNAMENT_KEY, highest_tournament.toString());
        this.setContent(obj, MAX_STAGE_KEY, max_stage.toString());
        this.setContent(obj, NAME_KEY, name);
        this.setContent(obj, PLAYER_CODE_KEY, player_code);
        this.setContent(obj, RANK_KEY, rank);
        this.setContent(obj, ROLE_KEY, role);
        this.setContent(obj, STAGE_KEY, stage);
        this.setContent(obj, TOTAL_CLAN_QUESTS_KEY, total_clan_quests.toString());
        this.setContent(obj, TOTAL_TOURNAMENTS_KEY, total_tournaments.toString());
        this.setContent(obj, WEEKLY_DUNGEON_COUNT_KEY, weekly_dungeon_count.toString());

        return obj;
    }
}
