package com.titansmasher.taptitans2optimiser.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 16/11/2016.
 */

public enum EquipmentCategory {
    Aura,
    Hat,
    Slash,
    Suit,
    Weapon;

    private static Map<String, EquipmentCategory> types = new HashMap<>();

    public static EquipmentCategory getCategory(String category) {
        if (types.size() == 0) {
            for (EquipmentCategory e :
                    values()) {
                types.put(e.toString(), e);
            }
        }
        return types.get(category);
    }
}
