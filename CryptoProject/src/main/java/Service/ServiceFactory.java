package Service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ServiceFactory {

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz   Java interface of the retrofit service
     * @param baseURL REST endpoint url
     * @return retrofit service with defined endpoint
     */
    static <T> T createRetrofitService(final Class<T> clazz, final String baseURL) {

        final Gson gson = new GsonBuilder()
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(clazz);
    }

}
