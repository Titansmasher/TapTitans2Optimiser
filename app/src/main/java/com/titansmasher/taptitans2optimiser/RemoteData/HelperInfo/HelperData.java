package com.titansmasher.taptitans2optimiser.RemoteData.HelperInfo;

import com.titansmasher.taptitans2optimiser.Enums.HelperType;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 17/11/2016.
 */

public class HelperData {
    public String heroId;
    public Integer order;
    public HelperType type;
    public Double purchaseCost;
    public Boolean isInGame;

    public HelperData(CSVRecord record) {
        this.heroId = record.get("HelperID");
        this.order = Integer.parseInt(record.get("UnlockOrder"));
        this.type = HelperType.getHelperType(record.get("HelperType"));
        this.purchaseCost = Double.parseDouble(record.get("PurchaseCost1"));
        this.isInGame = record.get("IsInGame").equals("1");
    }
}
