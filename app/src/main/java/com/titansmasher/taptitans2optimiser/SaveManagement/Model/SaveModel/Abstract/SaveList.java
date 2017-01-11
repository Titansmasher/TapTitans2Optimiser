package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract;

import android.support.annotation.NonNull;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Danny on 04/01/2017.
 */

public abstract class SaveList<V> extends SaveAbstract<JSONArray> implements List<V> {

    private List<V> arr;

    public SaveList() {
        super();
    }

    public SaveList(JSONArray obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        arr = new ArrayList<>();
    }

    @Override
    protected void populateFromJson(JSONArray obj) {
        arr = new ArrayList<>();

        for (int i = 0; i < obj.length(); i++) {
            try {
                arr.add(getObjectValue(obj.get(i)));
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public JSONArray getJson() {
        JSONArray obj = new JSONArray();

        for (int i = 0; i < arr.size(); i++) {
            try {
                obj.put(getJsonValue(arr.get(i)));
            } catch (Exception ex) {

            }
        }

        return obj;
    }

    protected abstract V getObjectValue(Object obj);

    protected abstract Object getJsonValue(V value);

    @Override
    public boolean add(V v) {
        return arr.add(v);
    }

    @Override
    public int size() {
        return arr.size();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return arr.contains(o);
    }

    @NonNull
    @Override
    public Iterator<V> iterator() {
        return arr.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return arr.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(T[] a) {
        return arr.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return arr.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return arr.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends V> c) {
        return arr.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends V> c) {
        return arr.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return arr.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return arr.retainAll(c);
    }

    @Override
    public void clear() {
        arr.clear();
    }

    @Override
    public V get(int index) {
        return arr.get(index);
    }

    @Override
    public V set(int index, V element) {
        return arr.set(index, element);
    }

    @Override
    public void add(int index, V element) {
        arr.add(index, element);
    }

    @Override
    public V remove(int index) {
        return arr.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return arr.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return arr.lastIndexOf(o);
    }

    @Override
    public ListIterator<V> listIterator() {
        return arr.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<V> listIterator(int index) {
        return arr.listIterator(index);
    }

    @NonNull
    @Override
    public List<V> subList(int fromIndex, int toIndex) {
        return arr.subList(fromIndex, toIndex);
    }
}
