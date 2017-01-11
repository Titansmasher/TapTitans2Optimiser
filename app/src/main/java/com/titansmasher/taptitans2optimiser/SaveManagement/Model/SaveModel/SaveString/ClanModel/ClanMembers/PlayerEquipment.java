package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ClanModel.ClanMembers;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;

import org.json.JSONObject;

/**
 * Created by Danny on 16/11/2016.
 */

public class PlayerEquipment extends SaveAbstract<JSONObject> {
    private static String AURA_KEY = "Aura";
    private static String HAT_KEY = "Hat";
    private static String SLASH_KEY = "Slash";
    private static String SUIT_KEY = "Suit";
    private static String WEAPON_KEY = "Weapon";
    public String aura;
    public String hat;
    public String slash;
    public String suit;
    public String weapon;

    public PlayerEquipment() {
        super();
    }

    public PlayerEquipment(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void populateFromNull() {
        aura = "AuraDefault";
        hat = "HatDefault";
        slash = "SlashDefault";
        suit = "SuitDefault";
        weapon = "WeaponDefault";

    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        aura = JSONHelpers.getStringSafe(obj, AURA_KEY);
        hat = JSONHelpers.getStringSafe(obj, HAT_KEY);
        slash = JSONHelpers.getStringSafe(obj, SLASH_KEY);
        suit = JSONHelpers.getStringSafe(obj, SUIT_KEY);
        weapon = JSONHelpers.getStringSafe(obj, WEAPON_KEY);
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, AURA_KEY, aura);
        JSONHelpers.putSafe(obj, HAT_KEY, hat);
        JSONHelpers.putSafe(obj, SLASH_KEY, slash);
        JSONHelpers.putSafe(obj, SUIT_KEY, suit);
        JSONHelpers.putSafe(obj, WEAPON_KEY, weapon);

        return obj;
    }
}
