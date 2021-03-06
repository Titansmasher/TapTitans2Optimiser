package com.titansmasher.taptitans2optimiser.RemoteData.PetInfo;

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

public class PetInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "PetInfo.csv";
    private static String assetLocation = "PetInfo.csv";

    private static Map<String, PetData> petMap = PetInfo.refreshFromAssets();

    public static PetData getEquipment(String equipmentId) {
        if (petMap.containsKey(equipmentId))
            return petMap.get(equipmentId);
        return null;
    }

    private static Map<String, PetData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<String, PetData> parseCSV(List<CSVRecord> records) {
        Map<String, PetData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(record.get("PetID"), new PetData(record));
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

                    petMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
