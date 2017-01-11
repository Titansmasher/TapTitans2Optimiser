package com.titansmasher.taptitans2optimiser.RemoteData.EquipmentInfo;

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
 * Created by Danny on 16/11/2016.
 */

public class EquipmentInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "EquipmentInfo.csv";
    private static String assetLocation = "EquipmentInfo.csv";

    private static Map<String, EquipmentData> equipmentMap = EquipmentInfo.refreshFromAssets();

    public static EquipmentData getEquipment(String equipmentId) {
        if (equipmentMap.containsKey(equipmentId))
            return equipmentMap.get(equipmentId);
        return null;
    }

    private static Map<String, EquipmentData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<String, EquipmentData> parseCSV(List<CSVRecord> records) {
        Map<String, EquipmentData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(record.get("EquipmentID"), new EquipmentData(record));
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

                    equipmentMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
