package com.titansmasher.taptitans2optimiser.RemoteData.PetInfo;

import com.titansmasher.taptitans2optimiser.Enums.Effect;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 18/11/2016.
 */

public class PetData {
    public String petID;
    public Double damageBase;
    public Double damageInc1to40;
    public Double damageInc41to80;
    public Double damageInc80on;
    public Effect bonusType;
    public Double bonusBase;
    public Double bonusInc;
    public Double total40;
    public Double total80;
    public Double total120;
    public Double total200;

    public PetData(CSVRecord record) {
        petID = record.get("PetID");
        damageBase = Double.parseDouble(record.get("DamageBase"));
        damageInc1to40 = Double.parseDouble(record.get("DamageInc1to40"));
        damageInc41to80 = Double.parseDouble(record.get("DamageInc41to80"));
        damageInc80on = Double.parseDouble(record.get("DamageInc80on"));
        bonusType = Effect.getEffect(record.get("BonusType"));
        bonusBase = Double.parseDouble(record.get("BonusBase"));
        bonusInc = Double.parseDouble(record.get("BonusInc"));
        total40 = Double.parseDouble(record.get("Total40"));
        total80 = Double.parseDouble(record.get("Total80"));
        total120 = Double.parseDouble(record.get("Total120"));
        total200 = Double.parseDouble(record.get("Total 200"));

    }
}
