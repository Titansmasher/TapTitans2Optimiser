package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 03/01/2017.
 */

public class TournamentModel extends SaveAbstract<JSONObject> {

    private static String CURRENTTOURNAMENT_KEY = "currentTournament";
    private static String NEXTTOURNAMENT_KEY = "nextTournament";
    private static String RETIREDUNTIL_KEY = "retiredUntil";
    public TournamentInfo currentTournament;
    public TournamentInfo nextTournament;
    public Date retiredUntil;

    public TournamentModel() {
        super();
    }

    public TournamentModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        currentTournament = new TournamentInfo();
        nextTournament = new TournamentInfo();
        retiredUntil = new Date(0);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentTournament = new TournamentInfo(JSONHelpers.getJSONObjectSafe(obj, CURRENTTOURNAMENT_KEY));
        nextTournament = new TournamentInfo(JSONHelpers.getJSONObjectSafe(obj, NEXTTOURNAMENT_KEY));
        retiredUntil = this.getDate(this.getStringContent(obj, RETIREDUNTIL_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, CURRENTTOURNAMENT_KEY, currentTournament.getJson());
        JSONHelpers.putSafe(obj, NEXTTOURNAMENT_KEY, nextTournament.getJson());
        this.setContent(obj, RETIREDUNTIL_KEY, retiredUntil);

        return obj;
    }
}
