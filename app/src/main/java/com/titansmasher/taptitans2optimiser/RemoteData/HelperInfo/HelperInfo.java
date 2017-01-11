package com.titansmasher.taptitans2optimiser.RemoteData.HelperInfo;

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
 * Created by Danny on 17/11/2016.
 */

public class HelperInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "HelperInfo.csv";
    private static String assetLocation = "HelperInfo.csv";

    private static Map<String, HelperData> helperMap = HelperInfo.refreshFromAssets();

    public static HelperData getHelper(String helperId) {
        if (helperMap.containsKey(helperId))
            return helperMap.get(helperId);
        return null;
    }

    private static Map<String, HelperData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<String, HelperData> parseCSV(List<CSVRecord> records) {
        Map<String, HelperData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(record.get("HelperID"), new HelperData(record));
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

                    helperMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
