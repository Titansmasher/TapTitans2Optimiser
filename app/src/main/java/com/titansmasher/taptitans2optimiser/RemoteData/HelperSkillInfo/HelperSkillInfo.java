package com.titansmasher.taptitans2optimiser.RemoteData.HelperSkillInfo;

import com.titansmasher.taptitans2optimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitans2optimiser.RemoteData.RemoteDataSettings;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 18/11/2016.
 */

public class HelperSkillInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "HelperSkillInfo.csv";
    private static String assetLocation = "HelperSkillInfo.csv";

    private static Map<String, List<Integer>> skillsForHelper = new HashMap<>();
    private static Map<Integer, HelperSkillData> helperSkillMap = HelperSkillInfo.refreshFromAssets();

    public static HelperSkillData getSkill(Integer skillId) {
        if (helperSkillMap.containsKey(skillId))
            return helperSkillMap.get(skillId);
        return null;
    }

    public static List<HelperSkillData> getSkillsForHero(String heroId) {
        List<HelperSkillData> output = new ArrayList<>();
        if (skillsForHelper.containsKey(heroId)) {
            List<Integer> skillIds = skillsForHelper.get(heroId);
            for (Integer skillId :
                    skillIds) {
                output.add(helperSkillMap.get(skillId));
            }
        }
        return output;
    }

    private static Map<Integer, HelperSkillData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<Integer, HelperSkillData> parseCSV(List<CSVRecord> records) {
        Map<Integer, HelperSkillData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            Integer skillID = Integer.parseInt(record.get("HelperSkillID"));
            HelperSkillData data = new HelperSkillData(record);

            returnMap.put(skillID, data);
            List<Integer> current;

            if (skillsForHelper.containsKey(data.owner)) {
                current = skillsForHelper.get(data.owner);
            } else {
                current = new ArrayList<>();
            }

            current.add(skillID);
            skillsForHelper.put(data.owner, current);
        }

        return returnMap;
    }

    public static void refreshData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream stream = new URL(downloadUrl).openStream();
                    Reader data = new InputStreamReader(stream, "UTF-8");
                    List<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(data).getRecords();
                    data.close();

                    skillsForHelper = new HashMap<>();
                    helperSkillMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
