package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FullDataResponse {

    @SerializedName("RAW")
    @Expose
    private RAW rawData;

    public RAW getRawData() {
        return rawData;
    }

}
