package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel;

import com.titansmasher.taptitans2optimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel.CachedTournamentData.CachedTournamentData;

import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Danny on 04/01/2017.
 */

public class TournamentInfo extends SaveAbstract<JSONObject> {
    private static String TOURNAMENTTYPE_KEY = "tournamentType";
    private static String TOURNAMENTID_KEY = "tournamentID";
    private static String PROGRESS_KEY = "progress";
    private static String PROGRESSREPORTED_KEY = "progressReported";
    private static String STARTTIME_KEY = "startTime";
    private static String ENDTIME_KEY = "endTime";
    private static String CACHEDTOURNAMENTDATA_KEY = "cachedTournamentData";
    private static String CACHEDTOURNAMENTDATATIMESTAMP_KEY = "cachedTournamentDataTimestamp";
    private static String TOURNAMENTBRACKET_KEY = "tournamentBracket";
    public String tournamentType;
    public UUID tournamentID;
    public CryptoObj progress;
    public CryptoObj progrssReported;
    public Date startTime;
    public Date endTime;
    public CachedTournamentData cachedTournamentData;
    public Date cachedTournamentDataTimestamp;
    public CryptoObj tournamentBracket;

    public TournamentInfo() {
        super();
    }

    public TournamentInfo(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        tournamentType = "";
        tournamentID = GenericHelpers.parseUUIDSafe("");
        progress = new CryptoObj();
        progrssReported = new CryptoObj();
        startTime = new Date(0);
        endTime = new Date(0);
        cachedTournamentData = new CachedTournamentData();
        cachedTournamentDataTimestamp = new Date(0);
        tournamentBracket = new CryptoObj();
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        tournamentType = JSONHelpers.getStringSafe(obj, TOURNAMENTTYPE_KEY);
        tournamentID = GenericHelpers.parseUUIDSafe(JSONHelpers.getStringSafe(obj, TOURNAMENTID_KEY));
        progress = new CryptoObj(JSONHelpers.getJSONObjectSafe(obj, PROGRESS_KEY));
        progrssReported = new CryptoObj(JSONHelpers.getJSONObjectSafe(obj, PROGRESSREPORTED_KEY));
        startTime = this.getDate(JSONHelpers.getStringSafe(obj, STARTTIME_KEY));
        endTime = this.getDate(JSONHelpers.getStringSafe(obj, ENDTIME_KEY));
        cachedTournamentData = new CachedTournamentData(JSONHelpers.getJSONObjectSafe(obj, CACHEDTOURNAMENTDATA_KEY));
        cachedTournamentDataTimestamp = this.getDate(JSONHelpers.getStringSafe(obj, CACHEDTOURNAMENTDATATIMESTAMP_KEY));
        tournamentBracket = new CryptoObj(JSONHelpers.getJSONObjectSafe(obj, TOURNAMENTBRACKET_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, TOURNAMENTTYPE_KEY, tournamentType);
        JSONHelpers.putSafe(obj, TOURNAMENTID_KEY, tournamentID.toString());
        JSONHelpers.putSafe(obj, PROGRESS_KEY, progress.getJson());
        JSONHelpers.putSafe(obj, PROGRESSREPORTED_KEY, progrssReported.getJson());
        JSONHelpers.putSafe(obj, STARTTIME_KEY, this.getDate(startTime));
        JSONHelpers.putSafe(obj, ENDTIME_KEY, this.getDate(endTime));
        JSONHelpers.putSafe(obj, CACHEDTOURNAMENTDATA_KEY, cachedTournamentData.getJson());
        JSONHelpers.putSafe(obj, CACHEDTOURNAMENTDATATIMESTAMP_KEY, this.getDate(cachedTournamentDataTimestamp));
        JSONHelpers.putSafe(obj, TOURNAMENTBRACKET_KEY, tournamentBracket);

        return obj;
    }
}
