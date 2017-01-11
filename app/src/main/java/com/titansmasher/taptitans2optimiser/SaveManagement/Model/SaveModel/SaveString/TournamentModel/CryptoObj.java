package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.TournamentModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 04/01/2017.
 */

public class CryptoObj extends SaveAbstract<JSONObject> {

    private static String CURRENTCRYPTOKEY_KEY = "currentCryptoKey";
    private static String HIDDENVALUE_KEY = "hiddenValue";
    private static String FAKEVALUE_KEY = "fakeValue";
    private static String INITED_KEY = "inited";
    public Integer currentCryptoKey;
    public Integer hiddenValue;
    public Integer fakeValue;
    public Boolean inited;

    public CryptoObj() {
        super();
    }

    public CryptoObj(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        currentCryptoKey = 0;
        hiddenValue = 0;
        fakeValue = 0;
        inited = false;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        currentCryptoKey = JSONHelpers.getIntegerSafe(obj, CURRENTCRYPTOKEY_KEY);
        hiddenValue = JSONHelpers.getIntegerSafe(obj, HIDDENVALUE_KEY);
        fakeValue = JSONHelpers.getIntegerSafe(obj, FAKEVALUE_KEY);
        inited = JSONHelpers.getBooleanSafe(obj, INITED_KEY, false);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, CURRENTCRYPTOKEY_KEY, currentCryptoKey);
        JSONHelpers.putSafe(obj, HIDDENVALUE_KEY, hiddenValue);
        JSONHelpers.putSafe(obj, FAKEVALUE_KEY, fakeValue);
        JSONHelpers.putSafe(obj, INITED_KEY, inited);

        return obj;
    }
}
