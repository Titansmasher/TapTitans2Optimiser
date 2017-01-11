package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract;

import com.titansmasher.taptitans2optimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Danny on 13/11/2016.
 */

public abstract class SaveAbstract<V> {
    protected static String CONTENT_KEY = "$content";
    protected static String TYPE_KEY = "$type";
    protected static String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSSSSSS";

    public SaveAbstract() {
        setup();
        populateFromNull();
    }

    public SaveAbstract(V obj) {
        setup();
        if (obj == null)
            populateFromNull();
        else
            populateFromJson(obj);
    }

    protected void setup() {
    }

    protected abstract void populateFromNull();

    protected abstract void populateFromJson(V obj);

    public abstract V getJson();

    public void setJson(V obj) {
        if (obj == null)
            populateFromNull();
        else
            populateFromJson(obj);
    }

    protected String getStringContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getStringSafe(parent, CONTENT_KEY);
    }

    protected Double getDoubleContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getDoubleSafe(parent, CONTENT_KEY);
    }

    protected Float getFloatContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getFloatSafe(parent, CONTENT_KEY);
    }

    protected Integer getIntegerContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getIntegerSafe(parent, CONTENT_KEY);
    }

    protected Long getLongContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getLongSafe(parent, CONTENT_KEY);
    }

    protected Boolean getBooleanContent(JSONObject obj, String key, Boolean defaultVal) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getBooleanSafe(parent, CONTENT_KEY, defaultVal);
    }

    protected JSONArray getJSONArrayContent(JSONObject obj, String key) {
        JSONObject parent = JSONHelpers.getJSONObjectSafe(obj, key);
        return JSONHelpers.getJSONArraySafe(parent, CONTENT_KEY);
    }

    protected <T> void setContent(JSONObject obj, String key, T value) {
        JSONObject nObj = new JSONObject();
        JSONHelpers.putSafe(nObj, CONTENT_KEY, value);
        JSONHelpers.putSafe(obj, key, nObj);
    }

    protected Date getDate(String date) {
        return GenericHelpers.parseDateSafe(DATE_FORMAT, date);
    }

    protected String getDate(Date date) {
        return GenericHelpers.formatDate(DATE_FORMAT, date);
    }
}
