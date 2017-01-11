package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanShipController;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveList;

import org.json.JSONObject;

/**
 * Created by Danny on 01/01/2017.
 */

public class ClanShipController extends SaveAbstract<JSONObject> {
    private static String CRATESONSCREEN_KEY = "cratesOnScreen";
    public SaveList<Crate> cratesOnScreen;

    public ClanShipController() {
        super();
    }

    public ClanShipController(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        cratesOnScreen = new SaveList<Crate>() {
            @Override
            protected Crate getObjectValue(Object obj) {
                return new Crate((JSONObject) obj);
            }

            @Override
            protected Object getJsonValue(Crate value) {
                return value.getJson();
            }
        };
    }

    @Override
    protected void populateFromNull() {
        cratesOnScreen.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        cratesOnScreen.setJson(getJSONArrayContent(obj, CRATESONSCREEN_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();
        this.setContent(obj, CRATESONSCREEN_KEY, cratesOnScreen.getJson());

        return obj;
    }
}
