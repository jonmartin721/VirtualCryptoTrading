
package POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RAW {

    @SerializedName("DASH")
    @Expose
    private SingleCryptoData DASH;
    @SerializedName("EOS")
    @Expose
    private SingleCryptoData EOS;
    @SerializedName("BTC")
    @Expose
    private SingleCryptoData BTC;
    @SerializedName("LTC")
    @Expose
    private SingleCryptoData LTC;
    @SerializedName("ETH")
    @Expose
    private SingleCryptoData ETH;
    @SerializedName("BCH")
    @Expose
    private SingleCryptoData BCH;
    @SerializedName("XRP")
    @Expose
    private SingleCryptoData XRP;
    @SerializedName("ADA")
    @Expose
    private SingleCryptoData ADA;
    @SerializedName("XMR")
    @Expose
    private SingleCryptoData XMR;
    @SerializedName("NEO")
    @Expose
    private SingleCryptoData NEO;

    public SingleCryptoData getDASH() {
        return DASH;
    }

    public SingleCryptoData getEOS() {
        return EOS;
    }

    public SingleCryptoData getBTC() {
        return BTC;
    }

    public SingleCryptoData getLTC() {
        return LTC;
    }

    public SingleCryptoData getETH() {
        return ETH;
    }

    public SingleCryptoData getBCH() {
        return BCH;
    }

    public SingleCryptoData getXRP() {
        return XRP;
    }

    public SingleCryptoData getXMR() {
        return XMR;
    }

    public SingleCryptoData getADA() {
        return ADA;
    }

    public SingleCryptoData getNEO() {
        return NEO;
    }
}
