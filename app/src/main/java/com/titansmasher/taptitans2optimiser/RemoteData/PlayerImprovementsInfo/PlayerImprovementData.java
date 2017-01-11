package com.titansmasher.taptitans2optimiser.RemoteData.PlayerImprovementsInfo;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 18/11/2016.
 */

public class PlayerImprovementData {
    public Integer level;
    public Double amount;
    public Double total;

    public PlayerImprovementData(CSVRecord record) {
        level = Integer.parseInt(record.get("Level"));
        amount = Double.parseDouble(record.get("Amount"));
    }
}
