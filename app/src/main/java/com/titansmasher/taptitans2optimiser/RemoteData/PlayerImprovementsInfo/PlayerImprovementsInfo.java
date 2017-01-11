package com.titansmasher.taptitans2optimiser.RemoteData.PlayerImprovementsInfo;

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

public class PlayerImprovementsInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "PlayerImprovementsInfo.csv";
    private static String assetLocation = "HelperImprovementsInfo.csv";

    private static Map<Integer, PlayerImprovementData> playerImprovementMap = PlayerImprovementsInfo.refreshFromAssets();

    public static PlayerImprovementData getImprovement(Integer level) {
        if (playerImprovementMap.containsKey(level))
            return playerImprovementMap.get(level);
        return null;
    }

    private static Map<Integer, PlayerImprovementData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<Integer, PlayerImprovementData> parseCSV(List<CSVRecord> records) {
        Map<Integer, PlayerImprovementData> returnMap = new HashMap<>();
        Double total = 1d;
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            PlayerImprovementData data = new PlayerImprovementData(record);
            total = total * data.amount;
            data.total = total;
            returnMap.put(data.level, data);
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

                    playerImprovementMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
