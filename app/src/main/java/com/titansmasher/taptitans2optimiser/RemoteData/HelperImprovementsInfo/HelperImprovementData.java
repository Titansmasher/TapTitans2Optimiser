package com.titansmasher.taptitans2optimiser.RemoteData.HelperImprovementsInfo;

import org.apache.commons.csv.CSVRecord;

/**
 * Created by Danny on 18/11/2016.
 */

public class HelperImprovementData {
    public Integer level;
    public Double amount;
    public Double total;
    public String benchmark;

    public HelperImprovementData(CSVRecord record) {
        level = Integer.parseInt(record.get("Level"));
        amount = Double.parseDouble(record.get("Amount"));
        total = Double.parseDouble(record.get("Total multiplier"));
        benchmark = record.get("Benchmark");
    }
}
