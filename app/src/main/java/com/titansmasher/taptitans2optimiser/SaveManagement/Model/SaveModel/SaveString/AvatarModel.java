package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class AvatarModel extends SaveAbstract<JSONObject> {

    private static String CURRENTAVATAR_KEY = "currentAvatar";
    private static String ALLAVATARISUNLOCKED_KEY = "allAvatarIsUnlocked";
    private static String ALLAVATARISNEW_KEY = "allAvatarIsNew";
    public String currentAvatar;
    public SaveDictionary<Boolean> allAvatarIsUnlocked;
    public SaveDictionary<Boolean> allAvatarIsNew;

    public AvatarModel() {
        super();
    }

    public AvatarModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allAvatarIsUnlocked = new SaveDictionary<Boolean>() {
            @Override
            protected Boolean getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getBooleanSafe(obj, key, false);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Boolean value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
        allAvatarIsNew = new SaveDictionary<Boolean>() {
            @Override
            protected Boolean getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getBooleanSafe(obj, key, false);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Boolean value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
    }

    @Override
    protected void populateFromNull() {
        currentAvatar = "";
        allAvatarIsUnlocked.setJson(null);
        allAvatarIsNew.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentAvatar = this.getStringContent(obj, CURRENTAVATAR_KEY);
        allAvatarIsUnlocked.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLAVATARISUNLOCKED_KEY));
        allAvatarIsNew.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLAVATARISNEW_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, CURRENTAVATAR_KEY, currentAvatar);
        JSONHelpers.putSafe(obj, ALLAVATARISUNLOCKED_KEY, allAvatarIsUnlocked.getJson());
        JSONHelpers.putSafe(obj, ALLAVATARISNEW_KEY, allAvatarIsNew.getJson());

        return obj;
    }
}
