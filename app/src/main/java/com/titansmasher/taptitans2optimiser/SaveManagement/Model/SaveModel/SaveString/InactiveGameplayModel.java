package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class InactiveGameplayModel extends SaveAbstract<JSONObject> {

    private static String UNCOLLECTEDINACTIVEGOLD_KEY = "uncollectedInactiveGold";
    public Double uncollectedInactiveGold;

    public InactiveGameplayModel() {
        super();
    }

    public InactiveGameplayModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        uncollectedInactiveGold = 0d;
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        uncollectedInactiveGold = this.getDoubleContent(obj, UNCOLLECTEDINACTIVEGOLD_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        this.setContent(obj, UNCOLLECTEDINACTIVEGOLD_KEY, uncollectedInactiveGold);

        return obj;
    }
}
