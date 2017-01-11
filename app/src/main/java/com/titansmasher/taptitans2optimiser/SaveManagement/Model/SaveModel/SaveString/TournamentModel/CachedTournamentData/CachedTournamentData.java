package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel.CachedTournamentData;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 04/01/2017.
 */

public class CachedTournamentData extends SaveAbstract<JSONObject> {

    private static String PLAYER_ABOVE_KEY = "player_above";
    private static String PLAYER_BELOW_KEY = "player_below";
    private static String PLAYER_SELF_KEY = "player_self";
    private static String TOP_PLAYERS_KEY = "top_players";
    private static String TOURNAMENT_OPEN_KEY = "tournament_open";
    public PlayerModel player_above;
    public PlayerModel player_below;
    public PlayerModel player_self;
    public SaveList<PlayerModel> top_players;
    public Boolean tournament_open;

    public CachedTournamentData() {
        super();
    }

    public CachedTournamentData(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        top_players = new SaveList<PlayerModel>() {
            @Override
            protected PlayerModel getObjectValue(Object obj) {
                return new PlayerModel((JSONObject) obj);
            }

            @Override
            protected Object getJsonValue(PlayerModel value) {
                return value.getJson();
            }
        };
    }

    @Override
    protected void populateFromNull() {
        player_above = new PlayerModel();
        player_below = new PlayerModel();
        player_self = new PlayerModel();
        top_players.setJson(null);
        tournament_open = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        player_above = new PlayerModel(JSONHelpers.getJSONObjectSafe(obj, PLAYER_ABOVE_KEY));
        player_below = new PlayerModel(JSONHelpers.getJSONObjectSafe(obj, PLAYER_BELOW_KEY));
        player_self = new PlayerModel(JSONHelpers.getJSONObjectSafe(obj, PLAYER_SELF_KEY));
        top_players.setJson(this.getJSONArrayContent(obj, TOP_PLAYERS_KEY));
        tournament_open = this.getBooleanContent(obj, TOURNAMENT_OPEN_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, PLAYER_ABOVE_KEY, player_above.getJson());
        JSONHelpers.putSafe(obj, PLAYER_BELOW_KEY, player_below.getJson());
        JSONHelpers.putSafe(obj, PLAYER_SELF_KEY, player_self.getJson());
        this.setContent(obj, TOP_PLAYERS_KEY, top_players.getJson());
        this.setContent(obj, TOURNAMENT_OPEN_KEY, tournament_open);

        return obj;
    }
}
