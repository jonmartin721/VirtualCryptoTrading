package Service;

import POJOs.FullDataResponse;
import POJOs.SingleCryptoData;
import POJOs.SingleValue;
import retrofit2.Call;

import java.io.IOException;
import java.util.ArrayList;

public class APICalls {

    private static CryptoCompareAPI service = ServiceFactory.createRetrofitService(CryptoCompareAPI.class, CryptoCompareAPI.BASE_URL);


    public static ArrayList<SingleCryptoData> getFullData() throws IOException {

        ArrayList<SingleCryptoData> cryptos = new ArrayList<>();
        Call<FullDataResponse> call = service.getFullData(RequestData.getCryptoString(), "USD", "VirtualCryptoTrading");
        FullDataResponse response = call.execute().body();
        //service.getFullData(RequestData.getCryptoString(), "USD", "VirtualCryptoTrading");

        if (response != null) {
            response.getRawData().getADA().setName("Ada");
            response.getRawData().getBCH().setName("BTC Cash");
            response.getRawData().getBTC().setName("Bitcoin");
            response.getRawData().getDASH().setName("Dash");
            response.getRawData().getEOS().setName("EOS");
            response.getRawData().getETH().setName("Ethereum");
            response.getRawData().getLTC().setName("Litecoin");
            response.getRawData().getNEO().setName("Neo");
            response.getRawData().getXMR().setName("Monero");
            response.getRawData().getXRP().setName("Ripple");
            cryptos.add(response.getRawData().getBTC());
            cryptos.add(response.getRawData().getBCH());
            cryptos.add(response.getRawData().getETH());
            cryptos.add(response.getRawData().getXRP());
            cryptos.add(response.getRawData().getLTC());
            cryptos.add(response.getRawData().getDASH());
            cryptos.add(response.getRawData().getXMR());
            cryptos.add(response.getRawData().getNEO());
            cryptos.add(response.getRawData().getEOS());
            cryptos.add(response.getRawData().getADA());
        }

        return cryptos;

    }

    public static SingleValue getSingleValue(String fromCrypto) throws IOException {

        Call<SingleValue> call = service.getSingleValue(fromCrypto, "USD", "VirtualCryptoTrading");
        return call.execute().body();
    }

    public static void apiError() {
        System.out.println("Could not retrieve API data.");
    }


}
