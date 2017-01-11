package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 01/01/2017.
 */

public class GHTime extends SaveAbstract<JSONObject> {
    private static String SERVEROFFSET_KEY = "serverOffset";
    private static String TOTALACTIVEGAMETIME_KEY = "totalActiveGameTime";
    private static String MAXDATETIME_KEY = "maxDateTime";
    private static String LASTINACTIVETIME_KEY = "lastInactiveTime";
    private static String LASTSYNCEDTIME_KEY = "lastSyncedTime";
    private static String GAMEINSTALLDATE_KEY = "gameInstallDate";
    public String serverOffset;
    public double totalActiveGameTime;
    public Date maxDateTime;
    public Date lastInactiveTime;
    public Date lastSyncedTime;
    public Date gameInstallDate;

    public GHTime(JSONObject obj) {
        super(obj);
    }

    public GHTime() {
        super();
    }

    @Override
    protected void populateFromNull() {
        serverOffset = "";
        totalActiveGameTime = 0;
        maxDateTime = new Date(0);
        lastInactiveTime = new Date(0);
        lastSyncedTime = new Date(0);
        gameInstallDate = new Date(0);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        serverOffset = this.getStringContent(obj, SERVEROFFSET_KEY);
        totalActiveGameTime = this.getDoubleContent(obj, TOTALACTIVEGAMETIME_KEY);
        maxDateTime = this.getDate(this.getStringContent(obj, MAXDATETIME_KEY));
        lastInactiveTime = this.getDate(this.getStringContent(obj, LASTINACTIVETIME_KEY));
        lastSyncedTime = this.getDate(this.getStringContent(obj, LASTSYNCEDTIME_KEY));
        gameInstallDate = this.getDate(this.getStringContent(obj, GAMEINSTALLDATE_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, SERVEROFFSET_KEY, serverOffset);
        this.setContent(obj, TOTALACTIVEGAMETIME_KEY, totalActiveGameTime);
        this.setContent(obj, MAXDATETIME_KEY, this.getDate(maxDateTime));
        this.setContent(obj, LASTINACTIVETIME_KEY, this.getDate(lastInactiveTime));
        this.setContent(obj, LASTSYNCEDTIME_KEY, this.getDate(lastSyncedTime));
        this.setContent(obj, GAMEINSTALLDATE_KEY, this.getDate(gameInstallDate));

        return obj;
    }
}
