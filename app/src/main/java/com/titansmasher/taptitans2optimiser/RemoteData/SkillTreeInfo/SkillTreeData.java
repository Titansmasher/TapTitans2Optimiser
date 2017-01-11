package com.titansmasher.taptitans2optimiser.RemoteData.SkillTreeInfo;

import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 18/11/2016.
 */

public class SkillTreeData {
    public String attribute;
    public String note;
    public String req;
    public Integer stageReq;
    public List<Integer> cost = new ArrayList<>();
    public List<Double> amount = new ArrayList<>();

    public SkillTreeData(CSVRecord record) {
        attribute = record.get("Attributes");
        note = record.get("Note");
        req = record.get("Req");
        stageReq = Integer.parseInt(record.get("StageReq"));
        for (int i = 0; i <= 20; i++) {
            String val = record.get("C" + i);
            if (val.equals("-"))
                cost.add(null);
            else
                cost.add(Integer.parseInt(val));
        }
        for (int i = 0; i < 20; i++) {
            String val = record.get("A" + i);
            if (val.equals("-"))
                amount.add(null);
            else
                amount.add(Double.parseDouble(val));
        }
    }
}
