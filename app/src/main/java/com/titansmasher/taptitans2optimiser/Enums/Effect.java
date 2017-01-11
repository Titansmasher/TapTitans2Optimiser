package com.titansmasher.taptitans2optimiser.Enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 16/11/2016.
 */

public enum Effect {
    ChestChance,
    CritChance,
    MonsterHP,
    AllHelperDamage,
    RangedHelperDamage,
    MeleeHelperDamage,
    SpellHelperDamage,
    AllDamage,
    PetDamageMult,
    TapDamage,
    CritDamage,
    ChestAmount,
    ManaRegen,
    SplashDamage;

    private static Map<String, Effect> effects = new HashMap<>();

    public static Effect getEffect(String effect) {
        if (effects.size() == 0) {
            for (Effect e :
                    values()) {
                effects.put(e.toString(), e);
            }
        }
        return effects.get(effect);
    }
}
