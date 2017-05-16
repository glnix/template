package ru.goryachev.gitclean;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.goryachev.gitclean.Requests.RequestModels.Quote;
import ru.goryachev.gitclean.Requests.RequestService.RequestService;
import ru.goryachev.gitclean.Requests.RequestService.UmoriliRequests;
import timber.log.Timber;

@InjectViewState
public class UmoriliQuotesPresenter extends MvpPresenter<UmoriliQuotesView> {

    public UmoriliQuotesPresenter() {
        Timber.d("UmoriliQuotesPresenter created!");
        requestService = RequestService.getInstance();
    }

    private RequestService requestService;

    void getQuotes() {
        UmoriliRequests umoriliRequests = requestService.getUmoriliRequests();

        Observable<List<Quote>> response = umoriliRequests.getRandomQuotes(10);

        response
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> getViewState().showQuotes(s),
                        e -> {
                            Timber.e(e.getMessage());
                            getViewState().showError(R.id.error_connection_failed);
                        }
                );
    }

}
