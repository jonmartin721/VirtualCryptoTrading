package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("close")
    @Expose
    private Double close;
    @SerializedName("high")
    @Expose
    private Double high;
    @SerializedName("low")
    @Expose
    private Double low;
    @SerializedName("open")
    @Expose
    private Double open;
    @SerializedName("volumefrom")
    @Expose
    private Double volumeFrom;
    @SerializedName("volumeto")
    @Expose
    private Double volumeTo;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getVolumeFrom() {
        return volumeFrom;
    }

    public void setVolumeFrom(Double volumeFrom) {
        this.volumeFrom = volumeFrom;
    }

    public Double getVolumeTo() {
        return volumeTo;
    }

    public void setVolumeTo(Double volumeTo) {
        this.volumeTo = volumeTo;
    }

}