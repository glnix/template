package ru.goryachev.gitclean.Requests.RequestService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.goryachev.gitclean.GtiCleanApp;
import ru.goryachev.gitclean.R;

public class RequestService {
    private static RequestService ourInstance;

    private Retrofit retrofit;

    public synchronized static RequestService getInstance() {
        if (ourInstance != null) {
            return ourInstance;
        }
        ourInstance = new RequestService();
        ourInstance.retrofit = new Retrofit.Builder()
                .baseUrl(GtiCleanApp.getApplication().getString(R.string.umorili_api_base_url))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return ourInstance;
    }

    private RequestService() {
    }

    private Retrofit getRetrofit() {
        return retrofit;
    }

    public UmoriliRequests getUmoriliRequests(){
        return getRetrofit().create(UmoriliRequests.class);
    }
}
