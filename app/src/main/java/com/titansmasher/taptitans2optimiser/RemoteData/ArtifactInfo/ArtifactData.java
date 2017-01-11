package com.titansmasher.taptitans2optimiser.RemoteData.ArtifactInfo;

import com.titansmasher.taptitans2optimiser.Enums.Effect;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 18/11/2016.
 */

public class ArtifactData {
    public String artifactID;
    public Integer maxLevel;
    public String tT1;
    public Effect bonusType;
    public Double effectPerLevel;
    public Double damageBonus;
    public Double costCoef;
    public Double costExpo;
    public String note;
    public String name;

    public ArtifactData(CSVRecord record) {
        artifactID = record.get("ArtifactID");
        maxLevel = Integer.parseInt(record.get("MaxLevel"));
        tT1 = record.get("TT1");
        bonusType = Effect.getEffect(record.get("BonusType"));
        effectPerLevel = Double.parseDouble(record.get("EffectPerLevel"));
        damageBonus = Double.parseDouble(record.get("DamageBonus"));
        costCoef = Double.parseDouble(record.get("CostCoef"));
        costExpo = Double.parseDouble(record.get("CostExpo"));
        note = record.get("Note");
        name = record.get("Name");
    }
}
