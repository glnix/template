package ru.goryachev.gitclean;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import ru.goryachev.gitclean.Requests.RequestModels.Quote;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements UmoriliQuotesView {
    @InjectPresenter()
    UmoriliQuotesPresenter umoriliQuotesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        umoriliQuotesPresenter.getQuotes();
    }

    @Override
    public void showQuotes(List<Quote> quotes) {
        Timber.d(quotes.toString());

    }

    @Override
    public void showError(int message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
