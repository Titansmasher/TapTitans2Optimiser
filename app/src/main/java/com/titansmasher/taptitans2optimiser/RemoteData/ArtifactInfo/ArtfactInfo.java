package com.titansmasher.taptitans2optimiser.RemoteData.ArtifactInfo;

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

public class ArtfactInfo {
    private static String downloadUrl = RemoteDataSettings.baseRemotePath + "ArtifactInfo.csv";
    private static String assetLocation = "ArtifactInfo.csv";

    private static Map<String, ArtifactData> artifactMap = ArtfactInfo.refreshFromAssets();

    public static ArtifactData getArtifact(String artifactId) {
        if (artifactMap.containsKey(artifactId))
            return artifactMap.get(artifactId);
        return null;
    }

    private static Map<String, ArtifactData> refreshFromAssets() {
        Reader data = GenericHelpers.getAssetReader(assetLocation);
        List<CSVRecord> records = GenericHelpers.parseCSV(data);

        return parseCSV(records);
    }

    private static Map<String, ArtifactData> parseCSV(List<CSVRecord> records) {
        Map<String, ArtifactData> returnMap = new HashMap<>();
        for (int i = 0; i < records.size(); i++) {
            CSVRecord record = records.get(i);

            returnMap.put(record.get("ArtifactID"), new ArtifactData(record));
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

                    artifactMap = parseCSV(records);
                } catch (Exception ex) {
                    return;
                }
            }
        }).start();
    }
}
