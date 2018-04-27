package Service;

import POJOs.FullDataResponse;
import POJOs.HistoData;
import POJOs.SingleValue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoCompareAPI {

    //to add new cryptos to query, add to RequestData class
    String BASE_URL = "https://min-api.cryptocompare.com/data/";

    @GET("pricemultifull")
    Call<FullDataResponse> getFullData(
            @Query("fsyms") String fromCryptos,
            @Query("tsyms") String toCryptos,
            @Query("extraParams") String extraParams);

    @GET("histoday")
    Call<HistoData> getHistoricalData(
            @Query("fsym") String fromCryptos,
            @Query("tsym") String toCryptos,
            @Query("limit") int limit,
            @Query("extraParams") String extraParams);

    @GET("price")
    Call<SingleValue> getSingleValue(
            @Query("fsym") String fromCryptos,
            @Query("tsyms") String toCryptos,
            @Query("extraParams") String extraParams);

}
