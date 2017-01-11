package com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.SaveString.ArtifactModel;

import com.titansmasher.taptitans2optimiser.Helpers.JSONHelpers;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveAbstract;
import com.titansmasher.taptitans2optimiser.SaveManagement.Model.SaveModel.Abstract.SaveDictionary;

import org.json.JSONObject;

/**
 * Created by Danny on 16/11/2016.
 */

public class ArtifactModel extends SaveAbstract<JSONObject> {
    private static String ALLARTIFACTINFO_KEY = "allArtifactInfo";
    public SaveDictionary<ArtifactSave> allArtifactInfo;

    public ArtifactModel() {
        super();
    }

    public ArtifactModel(JSONObject obj) {
        super(obj);
    }

    @Override
    protected void setup() {
        allArtifactInfo = new SaveDictionary<ArtifactSave>() {
            @Override
            protected ArtifactSave getJsonValue(JSONObject obj, String key) {
                return new ArtifactSave(JSONHelpers.getJSONObjectSafe(obj, key));
            }

            @Override
            protected void setJsonValue(JSONObject obj, String key, ArtifactSave value) {
                JSONHelpers.putSafe(obj, key, value.getJson());
            }
        };
    }

    @Override
    protected void populateFromNull() {
        allArtifactInfo.setJson(null);
    }

    @Override
    protected void populateFromJson(JSONObject obj) {
        allArtifactInfo.setJson(JSONHelpers.getJSONObjectSafe(obj, ALLARTIFACTINFO_KEY));
    }

    @Override
    public JSONObject getJson() {
        JSONObject obj = new JSONObject();

        JSONHelpers.putSafe(obj, ALLARTIFACTINFO_KEY, allArtifactInfo.getJson());

        return obj;
    }
}
