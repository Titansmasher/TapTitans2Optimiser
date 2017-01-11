package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Enums.AccountStatus;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 14/11/2016.
 */

public class AccountModel extends SaveAbstract<JSONObject> {
    private static String PLAYERID_KEY = "playerID";
    private static String DISPLAYNAME_KEY = "displayName";
    private static String EMAIL_KEY = "email";
    private static String AUTHTOKEN_KEY = "authToken";
    private static String COUNTRYCODE_KEY = "countryCode";
    private static String ACCOUNTSTATUS_KEY = "accountStatus";
    private static String ACCOUNTSTATE_KEY = "accountState";
    private static String REGISTEREDTIME_KEY = "registeredTime";
    private static String SUPPORTCODE_KEY = "supportCode";
    private static String FACEBOOKID_KEY = "facebookID";
    private static String ISDEV_KEY = "isDev";
    //1.1
    private static String PROMPTTIMES_KEY = "promptTimes";
    private static String PROMPTPRESTIGE_KEY = "promptPrestige";
    private static String INSTALLEDVERSION_KEY = "installedVersion";
    public String playerID;
    public String displayName;
    public String email;
    public String authToken;
    public String countryCode;
    public AccountStatus accountStatus;
    public Integer accountState;
    public Date registeredTime;
    public String supportCode;
    public String facebookID;
    public Boolean isDev;
    public Integer promptTimes;
    public Integer promptPrestige;
    public String installedVersion;

    public AccountModel() {
        super();
    }

    public AccountModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        playerID = "";
        displayName = "Sword Master";
        email = "";
        authToken = "";
        countryCode = "GB";
        accountStatus = AccountStatus.getFromString("");
        accountState = 0;
        registeredTime = new Date(0);
        supportCode = "";
        facebookID = "";
        isDev = false;

        promptTimes = 0;
        promptPrestige = -1;
        installedVersion = "1.0";
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        playerID = getStringContent(obj, PLAYERID_KEY);
        displayName = getStringContent(obj, DISPLAYNAME_KEY);
        email = getStringContent(obj, EMAIL_KEY);
        authToken = getStringContent(obj, AUTHTOKEN_KEY);
        countryCode = getStringContent(obj, COUNTRYCODE_KEY);
        accountStatus = AccountStatus.getFromString(getStringContent(obj, ACCOUNTSTATUS_KEY));
        accountState = getIntegerContent(obj, ACCOUNTSTATE_KEY);
        registeredTime = getDate(getStringContent(obj, REGISTEREDTIME_KEY));
        supportCode = getStringContent(obj, SUPPORTCODE_KEY);
        facebookID = getStringContent(obj, FACEBOOKID_KEY);
        isDev = getBooleanContent(obj, ISDEV_KEY, false);
        installedVersion = getStringContent(obj, INSTALLEDVERSION_KEY);
        promptTimes = getIntegerContent(obj, PROMPTTIMES_KEY);
        promptPrestige = getIntegerContent(obj, PROMPTPRESTIGE_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, PLAYERID_KEY, playerID);
        this.setContent(obj, DISPLAYNAME_KEY, displayName);
        this.setContent(obj, EMAIL_KEY, email);
        this.setContent(obj, AUTHTOKEN_KEY, authToken);
        this.setContent(obj, COUNTRYCODE_KEY, countryCode);
        this.setContent(obj, ACCOUNTSTATUS_KEY, accountStatus.toString());
        this.setContent(obj, ACCOUNTSTATE_KEY, accountState);
        this.setContent(obj, REGISTEREDTIME_KEY, this.getDate(registeredTime));
        this.setContent(obj, SUPPORTCODE_KEY, supportCode);
        this.setContent(obj, FACEBOOKID_KEY, facebookID);
        this.setContent(obj, ISDEV_KEY, isDev);

        this.setContent(obj, INSTALLEDVERSION_KEY, installedVersion);
        this.setContent(obj, PROMPTTIMES_KEY, promptTimes);
        this.setContent(obj, PROMPTPRESTIGE_KEY, promptPrestige);

        return obj;
    }
}
