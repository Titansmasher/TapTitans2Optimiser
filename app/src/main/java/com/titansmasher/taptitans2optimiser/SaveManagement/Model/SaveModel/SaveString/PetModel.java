package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 02/01/2017.
 */

public class PetModel extends SaveAbstract<JSONObject> {

    private static String CURRENTPET_KEY = "currentPet";
    private static String ALLPETLEVELS_KEY = "allPetLevels";
    private static String ALLPETNEW_KEY = "allPetNew";
    private static String DIDFIRSTEGGCOLLECTION_KEY = "didFirstEggCollection";
    private static String FIRSTEGGCOLLECTIONTIME_KEY = "firstEggCollectionTime";
    private static String LASTEGGCOLLECTIONTIME_KEY = "lastEggCollectionTime";
    private static String NUMBEROFEGGS_KEY = "NumberOfEggs";
    private static String EGGTIMERSTARTED_KEY = "eggTimerStarted";
    public String currentPet;
    public SaveDictionary<Integer> allPetLevels;
    public SaveDictionary<Boolean> allPetNew;
    public Boolean didFirstEggCollection;
    public Date firstEggCollectionTime;
    public Date lastEggCollectionTime;
    public Integer numberOfEggs;
    public Boolean eggTimerStarted;

    public PetModel() {
        super();
    }

    public PetModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allPetLevels = new SaveDictionary<Integer>() {
            @Override
            protected Integer getJsonValue(JSONObject obj, String key) {
                return JSONHelpers.getIntegerSafe(obj, key);
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, Integer value) {
                JSONHelpers.putSafe(obj, key, value);
            }
        };
        allPetNew = new SaveDictionary<Boolean>() {
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
        currentPet = "";
        allPetLevels.setJson(null);
        allPetNew.setJson(null);
        didFirstEggCollection = false;
        firstEggCollectionTime = new Date(0);
        lastEggCollectionTime = new Date(0);
        numberOfEggs = 0;
        eggTimerStarted = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentPet = this.getStringContent(obj, CURRENTPET_KEY);
        allPetLevels.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLPETLEVELS_KEY));
        allPetNew.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLPETNEW_KEY));
        didFirstEggCollection = this.getBooleanContent(obj, DIDFIRSTEGGCOLLECTION_KEY, false);
        firstEggCollectionTime = this.getDate(this.getStringContent(obj, FIRSTEGGCOLLECTIONTIME_KEY));
        lastEggCollectionTime = this.getDate(this.getStringContent(obj, LASTEGGCOLLECTIONTIME_KEY));
        numberOfEggs = this.getIntegerContent(obj, NUMBEROFEGGS_KEY);
        eggTimerStarted = this.getBooleanContent(obj, EGGTIMERSTARTED_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, CURRENTPET_KEY, currentPet);
        JSONHelpers.putSafe(obj, ALLPETLEVELS_KEY, allPetLevels.getJson());
        JSONHelpers.putSafe(obj, ALLPETNEW_KEY, allPetNew.getJson());
        this.setContent(obj, DIDFIRSTEGGCOLLECTION_KEY, didFirstEggCollection);
        this.setContent(obj, FIRSTEGGCOLLECTIONTIME_KEY, this.getDate(firstEggCollectionTime));
        this.setContent(obj, LASTEGGCOLLECTIONTIME_KEY, this.getDate(lastEggCollectionTime));
        this.setContent(obj, NUMBEROFEGGS_KEY, numberOfEggs);
        this.setContent(obj, EGGTIMERSTARTED_KEY, eggTimerStarted);

        return obj;
    }
}
