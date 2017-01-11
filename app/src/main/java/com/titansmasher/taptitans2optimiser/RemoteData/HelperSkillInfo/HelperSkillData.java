package com.titansmasher.taptitans2optimiser.RemoteData.HelperSkillInfo;

import com.titansmasher.taptitans2optimiser.Enums.Effect;
import com.titansmasher.taptitans2optimiser.Helpers.GenericHelpers;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 18/11/2016.
 */

public class HelperSkillData {
    public Integer helperSkillId;
    public String owner;
    public String name;
    public Effect bonusType;
    public Double magnitude;
    public Integer requiredLevel;

    public HelperSkillData(CSVRecord record) {
        helperSkillId = Integer.parseInt(record.get("HelperSkillID"));
        owner = record.get("Owner");
        name = record.get("Name");
        bonusType = Effect.getEffect(record.get("BonusType"));
        magnitude = GenericHelpers.isDouble(record.get("Magnitude")) ? Double.parseDouble(record.get("Magnitude")) : 0;
        requiredLevel = GenericHelpers.isInteger(record.get("RequiredLevel")) ? Integer.parseInt(record.get("RequiredLevel")) : 0;
    }
}
