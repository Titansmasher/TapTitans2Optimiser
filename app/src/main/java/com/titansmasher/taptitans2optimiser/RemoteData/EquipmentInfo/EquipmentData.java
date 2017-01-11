package com.titansmasher.taptitans2optimiser.RemoteData.EquipmentInfo;

import com.titansmasher.taptitans2optimiser.Enums.Effect;
import com.titansmasher.taptitans2optimiser.Enums.EquipmentCategory;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 16/11/2016.
 */

public class EquipmentData {
    public String id;
    public EquipmentCategory category;
    public Effect effect;
    public Double baseAmount;
    public Integer rarity;
    public Double baseIncrease;

    public EquipmentData(CSVRecord record) {
        this.id = record.get("EquipmentID");
        this.category = EquipmentCategory.getCategory(record.get("EquipmentCategory"));
        this.effect = Effect.getEffect(record.get("BonusType"));
        this.baseAmount = Double.parseDouble(record.get("AttributeBaseAmount"));
        this.rarity = Integer.parseInt(record.get("Rarity"));
        this.baseIncrease = Double.parseDouble(record.get("AttributeBaseInc"));
    }
}
