package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 20/11/2016.
 */

public class ClanMessage extends SaveAbstract<JSONObject> {
    private static String CLANMESSAGETYPE_KEY = "clanMessageType";
    private static String MESSAGE_KEY = "message";
    private static String MEMBERNAME_KEY = "memberName";
    private static String TIMESTAMP_KEY = "timeStamp";
    private static String ISME_KEY = "isMe";
    private static String PERKID_KEY = "perkID";
    private static String PERKDURATION_KEY = "perkDuration";
    private static String ROLE_KEY = "role";
    private static String ID_KEY = "id";
    public String clanMessageType;
    public String message;
    public String memberName;
    public Date timeStamp;
    public Boolean isMe;
    public String perkID;
    public Double perkDuration;
    public String role;
    public Integer id;

    public ClanMessage() {
        super();
    }

    public ClanMessage(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        clanMessageType = "";
        message = "";
        memberName = "";
        timeStamp = new Date(0);
        isMe = false;
        perkID = "";
        perkDuration = 0d;
        role = "";
        id = 0;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        clanMessageType = JSONHelpers.getStringSafe(obj, CLANMESSAGETYPE_KEY);
        message = JSONHelpers.getStringSafe(obj, MESSAGE_KEY);
        memberName = JSONHelpers.getStringSafe(obj, MEMBERNAME_KEY);
        timeStamp = getDate(JSONHelpers.getStringSafe(obj, TIMESTAMP_KEY));
        isMe = JSONHelpers.getBooleanSafe(obj, ISME_KEY, false);
        perkID = JSONHelpers.getStringSafe(obj, PERKID_KEY);
        perkDuration = JSONHelpers.getDoubleSafe(obj, PERKDURATION_KEY);
        role = JSONHelpers.getStringSafe(obj, ROLE_KEY);
        id = JSONHelpers.getIntegerSafe(obj, ID_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, CLANMESSAGETYPE_KEY, clanMessageType);
        JSONHelpers.putSafe(obj, MESSAGE_KEY, message);
        JSONHelpers.putSafe(obj, MEMBERNAME_KEY, memberName);
        JSONHelpers.putSafe(obj, TIMESTAMP_KEY, getDate(timeStamp));
        JSONHelpers.putSafe(obj, ISME_KEY, isMe);
        JSONHelpers.putSafe(obj, PERKID_KEY, perkID);
        JSONHelpers.putSafe(obj, PERKDURATION_KEY, perkDuration);
        JSONHelpers.putSafe(obj, ROLE_KEY, role);
        JSONHelpers.putSafe(obj, ID_KEY, id);

        return obj;
    }
}
