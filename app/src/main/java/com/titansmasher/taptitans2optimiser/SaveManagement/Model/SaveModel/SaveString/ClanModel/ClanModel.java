package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel.ClanMembers.ClanMember;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 16/11/2016.
 */

public class ClanModel extends SaveAbstract<JSONObject> {
    private static String CLAN_KEY = "clan";
    private static String CLANMEMBERS_KEY = "clanMembers";
    private static String CLANMESSAGES_KEY = "clanMessages";
    //1.1
    private static String LASTMESSAGEID_KEY = "lastMessageId";
    private static String NUMBEROFNEWMESSAGES_KEY = "numberOfNewMessages";
    private static String LASTVIEWEDMESSAGEBOARD_KEY = "lastViewMessageBoard";
    private static String SHOULDSHOWKICKEDPANEL_KEY = "shouldShowKickedPanel";
    public Clan clan;
    public SaveDictionary<ClanMember> clanMembers;
    public SaveList<ClanMessage> clanMessages;
    public Long lastMessageId;
    public Integer numberOfNewMessages;
    public Date lastViewMessageBord;
    public Boolean shouldShowKickedPanel;


    public ClanModel() {
        super();
    }

    public ClanModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        clanMembers = new SaveDictionary<ClanMember>() {
            @Override
            protected ClanMember getJsonValue(JSONObject obj, String key) {
                return new ClanMember(JSONHelpers.getJSONObjectSafe(obj, key));
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, ClanMember value) {
                JSONHelpers.putSafe(obj, key, value.getJson());
            }
        };

        clanMessages = new SaveList<ClanMessage>() {
            @Override
            protected ClanMessage getObjectValue(Object obj) {
                return new ClanMessage((JSONObject) obj);
            }

            @Override
            protected Object getJsonValue(ClanMessage value) {
                return value.getJson();
            }
        };
    }

    @Override
    protected void populateFromNull() {
        clan = new Clan();
        clanMembers.setJson(null);
        clanMessages.setJson(null);
        lastMessageId = 0l;
        numberOfNewMessages = 0;
        lastViewMessageBord = new Date(0);
        shouldShowKickedPanel = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        clan = new Clan(JSONHelpers.getJSONObjectSafe(obj, CLAN_KEY));
        clanMembers.setJson(JSONHelpers.getJSONObjectSafe(obj, CLANMEMBERS_KEY));
        clanMessages.setJson(getJSONArrayContent(obj, CLANMESSAGES_KEY));
        lastMessageId = JSONHelpers.getLongSafe(obj, LASTMESSAGEID_KEY);
        numberOfNewMessages = JSONHelpers.getIntegerSafe(obj, NUMBEROFNEWMESSAGES_KEY);
        lastViewMessageBord = getDate(this.getStringContent(obj, LASTVIEWEDMESSAGEBOARD_KEY));
        shouldShowKickedPanel = JSONHelpers.getBooleanSafe(obj, SHOULDSHOWKICKEDPANEL_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, CLAN_KEY, clan.getJson());
        JSONHelpers.putSafe(obj, CLANMEMBERS_KEY, clanMembers.getJson());
        this.setContent(obj, CLANMESSAGES_KEY, clanMessages.getJson());
        this.setContent(obj, LASTMESSAGEID_KEY, lastMessageId);
        this.setContent(obj, NUMBEROFNEWMESSAGES_KEY, numberOfNewMessages);
        this.setContent(obj, LASTVIEWEDMESSAGEBOARD_KEY, getDate(lastViewMessageBord));
        this.setContent(obj, SHOULDSHOWKICKEDPANEL_KEY, shouldShowKickedPanel);

        return obj;

    }
}
