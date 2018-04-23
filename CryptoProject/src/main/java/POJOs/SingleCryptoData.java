package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleCryptoData {

    @SerializedName("USD")
    @Expose
    private USD singleCryptoData;
    private String name;

    public USD getRaw() {
        return singleCryptoData;
    }

    public void setRaw(USD uSD) {
        this.singleCryptoData = uSD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

