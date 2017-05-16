package ru.goryachev.gitclean.Requests.RequestService;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.goryachev.gitclean.Requests.RequestModels.Quote;

public interface UmoriliRequests {

    @GET("api/random")
    Observable<List<Quote>> getRandomQuotes(@Query("num") int num);
}
