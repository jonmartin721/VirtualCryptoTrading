package Service;

import java.util.ArrayList;
import java.util.List;

class RequestData {
    private static List<String> cryptoList = new ArrayList<>() {{

        //here is added all the currencies I want to query with the API
        add("BTC");
        add("ETH");
        add("XRP");
        add("DASH");
        add("BCH");
        add("ZCH");
        add("LTC");
        add("EOS");
        add("ADA");
        add("XMR");
        add("NEO");

    }};

    //creates and sends back a string to be used for fromCryptos in the API
    static String getCryptoString() {
        StringBuilder cryptoListString = new StringBuilder();
        for (int i = 0; i < cryptoList.size(); i++) {
            cryptoListString.append(cryptoList.get(i));
            if (cryptoList.size() - 1 != i)
                cryptoListString.append(",");
        }

        return cryptoListString.toString();
    }
}