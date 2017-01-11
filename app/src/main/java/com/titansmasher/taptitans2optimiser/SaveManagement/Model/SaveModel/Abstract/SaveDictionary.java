package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract;

import android.support.annotation.NonNull;

import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Danny on 04/01/2017.
 */

public abstract class SaveDictionary<K> extends SaveAbstract<JSONObject> implements Map<String, K> {

    private Map<String, K> dict;

    public SaveDictionary() {
        super();
    }

    public SaveDictionary(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        dict = new HashMap<>();
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        dict = new HashMap<>();

        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (key.startsWith("$"))
                continue;
            dict.put(key, getJsonValue(obj, key));
        }
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        for (String key :
                dict.keySet()) {
            setJsonValue(obj, key, dict.get(key));
        }

        return obj;
    }

    protected abstract K getJsonValue(JSONObject obj, String key);

    protected abstract void setJsonValue(JSONObject obj, String key, K value);

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public boolean isEmpty() {
        return dict.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return dict.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return dict.containsValue(value);
    }

    @Override
    public K get(Object key) {
        return dict.get(key);
    }

    @Override
    public K put(String key, K value) {
        return dict.put(key, value);
    }

    @Override
    public K remove(Object key) {
        return dict.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends K> m) {
        dict.putAll(m);
    }

    @Override
    public void clear() {
        dict.clear();
    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return dict.keySet();
    }

    @NonNull
    @Override
    public Collection<K> values() {
        return dict.values();
    }

    @NonNull
    @Override
    public Set<Entry<String, K>> entrySet() {
        return dict.entrySet();
    }
}
