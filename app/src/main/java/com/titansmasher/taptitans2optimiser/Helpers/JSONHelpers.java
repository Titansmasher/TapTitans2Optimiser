package com.titansmasher.taptitans2optimiser.Helpers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Danny on 13/11/2016.
 */

public class JSONHelpers {
    public static JSONObject getJSONObjectSafe(JSONObject obj, String name) {
        try {
            return obj.getJSONObject(name);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static JSONArray getJSONArraySafe(JSONObject obj, String name) {
        try {
            return obj.getJSONArray(name);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static String getStringSafe(JSONObject obj, String name) {
        try {
            return obj.getString(name);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static Integer getIntegerSafe(JSONObject obj, String name) {
        try {
            return obj.getInt(name);
        } catch (JSONException ex) {
            return 0;
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    public static Long getLongSafe(JSONObject obj, String name) {
        try {
            return obj.getLong(name);
        } catch (JSONException ex) {
            return 0l;
        } catch (NullPointerException ex) {
            return 0l;
        }
    }

    public static Double getDoubleSafe(JSONObject obj, String name) {
        try {
            return obj.getDouble(name);
        } catch (JSONException ex) {
            return 0d;
        } catch (NullPointerException ex) {
            return 0d;
        }
    }

    public static Float getFloatSafe(JSONObject obj, String name) {
        try {
            return (float) obj.getDouble(name);
        } catch (JSONException ex) {
            return 0f;
        } catch (NullPointerException ex) {
            return 0f;
        }
    }

    public static Boolean getBooleanSafe(JSONObject obj, String name, Boolean defaultVal) {
        try {
            return obj.getBoolean(name);
        } catch (JSONException ex) {
            return defaultVal;
        } catch (NullPointerException ex) {
            return defaultVal;
        }
    }

    public static <T> void putSafe(JSONObject obj, String name, T value) {
        try {
            obj.put(name, value);
        } catch (JSONException ex) {
        } catch (NullPointerException ex) {
        }
    }

    public static JSONObject constructJSONObjectSafe(String jsonText) {
        try {
            return new JSONObject(jsonText);
        } catch (JSONException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
