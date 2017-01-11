package com.titansmasher.taptitans2optimiser.RemoteData.SkillTreeInfo;

import com.titansmasher.taptitans2optimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitans2optimiser.RemoteData.RemoteDataSettings;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Danny on 19/11/2016.
 */

public class SkillTreeInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "SkillTreeInfo.csv";
    private static String assetLocation = "SkillTreeInfo.csv";

    private static Map<String, SkillTreeData> skillTreeMap = SkillTreeInfo.refreshFromAssets();

    public static SkillTreeData getSkill(String skill) {
        if (skillTreeMap.containsKey(skill))
            return skillTreeMap.get(skill);
        return null;
    }

    private static Map<String, SkillTreeData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<String, SkillTreeData> parseCSV(List<CSVRecord> records) {
        Map<String, SkillTreeData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(record.get("Attributes"), new SkillTreeData(record));
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

                    skillTreeMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
