package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.PerkModel;

import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 02/01/2017.
 */

public class PerkModel extends SaveAbstract<JSONObject> {

    private static String DOOMCREDITS_KEY = "doomCredits";
    private static String MAKEITRAINCREDITS_KEY = "makeItRainCredits";
    private static String CLANMAKEITRAINCREDITS_KEY = "clanMakeItRainCredits";
    private static String POWEROFSWIPINGCREDITS_KEY = "powerOfSwipeCredits";
    private static String DOUBLEDAMAGECREDITS_KEY = "doubleDamageCredits";
    public PerkCredits doomCredits;
    public PerkCredits makeItRainCredits;
    public PerkCredits clanMakeItRainCredits;
    public PerkCredits powerOfSwipeCredits;
    public PerkCredits doubleDamageCredits;

    public PerkModel() {
        super();
    }

    public PerkModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        doomCredits = new PerkCredits(DOOMCREDITS_KEY);
        makeItRainCredits = new PerkCredits(MAKEITRAINCREDITS_KEY);
        clanMakeItRainCredits = new PerkCredits(CLANMAKEITRAINCREDITS_KEY);
        powerOfSwipeCredits = new PerkCredits(POWEROFSWIPINGCREDITS_KEY);
        doubleDamageCredits = new PerkCredits(DOUBLEDAMAGECREDITS_KEY);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        doomCredits = new PerkCredits(obj, DOOMCREDITS_KEY);
        makeItRainCredits = new PerkCredits(obj, MAKEITRAINCREDITS_KEY);
        clanMakeItRainCredits = new PerkCredits(obj, CLANMAKEITRAINCREDITS_KEY);
        powerOfSwipeCredits = new PerkCredits(obj, POWEROFSWIPINGCREDITS_KEY);
        doubleDamageCredits = new PerkCredits(obj, DOUBLEDAMAGECREDITS_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        doomCredits.addJson(obj);
        makeItRainCredits.addJson(obj);
        clanMakeItRainCredits.addJson(obj);
        powerOfSwipeCredits.addJson(obj);
        doubleDamageCredits.addJson(obj);

        return obj;
    }
}
