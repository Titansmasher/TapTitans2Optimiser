package com.titansmasher.taptitans2optimiser.RemoteData.HelperImprovementsInfo;

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
 * Created by Danny on 18/11/2016.
 */

public class HelperImprovementInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "HelperImprovementsInfo.csv";
    private static String assetLocation = "HelperImprovementsInfo.csv";

    private static Map<Integer, HelperImprovementData> helperImprovementMap = HelperImprovementInfo.refreshFromAssets();

    public static HelperImprovementData getImprovement(Integer level) {
        if (helperImprovementMap.containsKey(level))
            return helperImprovementMap.get(level);
        return null;
    }

    private static Map<Integer, HelperImprovementData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<Integer, HelperImprovementData> parseCSV(List<CSVRecord> records) {
        Map<Integer, HelperImprovementData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(Integer.parseInt(record.get("Level")), new HelperImprovementData(record));
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

                    helperImprovementMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
