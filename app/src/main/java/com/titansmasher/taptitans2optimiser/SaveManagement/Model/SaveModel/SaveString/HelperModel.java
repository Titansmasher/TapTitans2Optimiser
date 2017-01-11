package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 01/01/2017.
 */

public class HelperModel extends SaveAbstract<JSONObject> {

    private static String ALLHELPERLEVELS_KEY = "allHelperLevels";
    private static String ISUNREADSTORY_KEY = "isUnreadStory";
    private static String HELPERSTORYUNLOCKED_KEY = "helperStoryUnlocked";
    private static String ALLUNLOCKEDHELPERSKILLS_KEY = "allUnlockedHelperSkills";
    private static String ALLHELPERWEAPONLEVELS_KEY = "allHelperWeaponLevels";
    public SaveDictionary<Integer> allHelperLevels;
    public Boolean isUnreadStory;
    public List<String> helperStoryUnlocked;
    public List<String> allUnlockedHelperSkills;
    public SaveDictionary<Integer> allHelperWeaponLevels;

    public HelperModel() {
        super();
    }

    public HelperModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allHelperLevels = new SaveDictionary<Integer>() {
            @Override
            protected Integer getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getIntegerSafe(obj, key);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Integer value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
        allHelperWeaponLevels = new SaveDictionary<Integer>() {
            @Override
            protected Integer getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getIntegerSafe(obj, key);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Integer value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
    }

    @Override
    protected void populateFromNull() {
        allHelperLevels.setJson(null);
        isUnreadStory = false;
        helperStoryUnlocked = new ArrayList<>();
        allUnlockedHelperSkills = new ArrayList<>();
        allHelperWeaponLevels.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        allHelperLevels.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLHELPERLEVELS_KEY));
        isUnreadStory = this.getBooleanContent(obj, ISUNREADSTORY_KEY, false);
        helperStoryUnlocked = new ArrayList<>();
        JSONArray arr = this.getJSONArrayContent(obj, HELPERSTORYUNLOCKED_KEY);
        for (int i = 0; i < arr.length(); i++) {
            try {
                helperStoryUnlocked.add(arr.getString(i));
            } catch (Exception ex) {

            }
        }
        allUnlockedHelperSkills = new ArrayList<>();
        arr = this.getJSONArrayContent(obj, ALLUNLOCKEDHELPERSKILLS_KEY);
        for (int i = 0; i < arr.length(); i++) {
            try {
                allUnlockedHelperSkills.add(arr.getString(i));
            } catch (Exception ex) {

            }
        }
        allHelperWeaponLevels.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLHELPERWEAPONLEVELS_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, ALLHELPERLEVELS_KEY, allHelperLevels.getJson());
        this.setContent(obj, ISUNREADSTORY_KEY, isUnreadStory);
        JSONArray arr = new JSONArray();
        for (int i = 0; i < helperStoryUnlocked.size(); i++) {
            arr.put(helperStoryUnlocked.get(i));
        }
        this.setContent(obj, HELPERSTORYUNLOCKED_KEY, arr);
        arr = new JSONArray();
        for (int i = 0; i < allUnlockedHelperSkills.size(); i++) {
            arr.put(allUnlockedHelperSkills.get(i));
        }
        this.setContent(obj, ALLUNLOCKEDHELPERSKILLS_KEY, arr);
        JSONHelpers.putSafe(obj, ALLHELPERWEAPONLEVELS_KEY, allHelperWeaponLevels.getJson());

        return obj;
    }
}
