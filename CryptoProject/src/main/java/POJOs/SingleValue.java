package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleValue {

    @SerializedName("USD")
    @Expose
    private Double value;

    public Double getValue() {
        return value;
    }

    public void getValue(Double value) {
        this.value = value;
    }

}