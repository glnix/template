package ru.goryachev.gitclean;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.goryachev.gitclean.Requests.RequestModels.Quote;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface UmoriliQuotesView extends MvpView {
    void showQuotes(List<Quote> quotes);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(int message);
}
