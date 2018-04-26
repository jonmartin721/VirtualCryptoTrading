
package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USD {

    @SerializedName("TYPE")
    @Expose
    private String type;
    @SerializedName("MARKET")
    @Expose
    private String market;
    @SerializedName("FROMSYMBOL")
    @Expose
    private String fromSymbol;
    @SerializedName("TOSYMBOL")
    @Expose
    private String toSymbol;
    @SerializedName("FLAGS")
    @Expose
    private String flags;
    @SerializedName("PRICE")
    @Expose
    private Double price;
    @SerializedName("LASTUPDATE")
    @Expose
    private Integer lastUpdate;
    @SerializedName("LASTVOLUME")
    @Expose
    private Double lastVolume;
    @SerializedName("LASTVOLUMETO")
    @Expose
    private Double lastVolumeTotal;
    @SerializedName("LASTTRADEID")
    @Expose
    private String lastTraded;
    @SerializedName("VOLUMEDAY")
    @Expose
    private Double volumeDay;
    @SerializedName("VOLUMEDAYTO")
    @Expose
    private Double volumeDayTotal;
    @SerializedName("VOLUME24HOUR")
    @Expose
    private Double volume24Hour;
    @SerializedName("VOLUME24HOURTO")
    @Expose
    private Double volume24HourTotal;
    @SerializedName("OPENDAY")
    @Expose
    private Double openDay;
    @SerializedName("HIGHDAY")
    @Expose
    private Double highDay;
    @SerializedName("LOWDAY")
    @Expose
    private Double lowDay;
    @SerializedName("OPEN24HOUR")
    @Expose
    private Double open24Hour;
    @SerializedName("HIGH24HOUR")
    @Expose
    private Double high24Hour;
    @SerializedName("LOW24HOUR")
    @Expose
    private Double low24Hour;
    @SerializedName("LASTMARKET")
    @Expose
    private String lastMarket;
    @SerializedName("CHANGE24HOUR")
    @Expose
    private Double change24Hour;
    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    private Double changePercent24Hour;
    @SerializedName("CHANGEDAY")
    @Expose
    private Double changeDay;
    @SerializedName("CHANGEPCTDAY")
    @Expose
    private Double changePercentDay;
    @SerializedName("SUPPLY")
    @Expose
    private Double supply;
    @SerializedName("MKTCAP")
    @Expose
    private Double marketCap;
    @SerializedName("TOTALVOLUME24H")
    @Expose
    private Double totalVolume24Hour;
    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    private Double totalVolume24HourTotal;

    public String getType() {
        return type;
    }

    public String getmARKET() {
        return market;
    }

    public String getFromSymbol() {
        return fromSymbol;
    }

    public String getToSymbol() {
        return toSymbol;
    }

    public String getFlags() {
        return flags;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getLastUpdate() {
        return lastUpdate;
    }

    public Double getLastVolume() {
        return lastVolume;
    }

    public Double getLastVolumeTotal() {
        return lastVolumeTotal;
    }

    public String getLastTraded() {
        return lastTraded;
    }

    public Double getVolumeDay() {
        return volumeDay;
    }

    public Double getVolumeDayTotal() {
        return volumeDayTotal;
    }

    public Double getVolume24Hour() {
        return volume24Hour;
    }

    public Double getVolume24HourTotal() {
        return volume24HourTotal;
    }

    public Double getOpenDay() {
        return openDay;
    }

    public Double getHighDay() {
        return highDay;
    }

    public Double getLowDay() {
        return lowDay;
    }

    public Double getOpen24Hour() {
        return open24Hour;
    }

    public Double getHigh24Hour() {
        return high24Hour;
    }

    public Double getLow24Hour() {
        return low24Hour;
    }

    public String getLastMarket() {
        return lastMarket;
    }

    public Double getChange24Hour() {
        return change24Hour;
    }

    public Double getChangePercent24Hour() {
        return changePercent24Hour;
    }

    public Double getChangeDay() {
        return changeDay;
    }

    public Double getChangePercentDay() {
        return changePercentDay;
    }

    public Double getSupply() {
        return supply;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public Double getTotalVolume24Hour() {
        return totalVolume24Hour;
    }

    public Double getTotalVolume24HourTotal() {
        return totalVolume24HourTotal;
    }
}
