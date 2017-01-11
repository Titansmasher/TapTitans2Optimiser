package com.titansmasher.taptitans2optimiser.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 17/11/2016.
 */

public enum HelperType {
    Spell,
    Ranged,
    Melee;

    private static Map<String, HelperType> helperTypes = new HashMap<>();

    public static HelperType getHelperType(String type) {
        if (helperTypes.size() == 0) {
            for (HelperType h :
                    values()) {
                helperTypes.put(h.toString(), h);
            }
        }
        return helperTypes.get(type);
    }
}
