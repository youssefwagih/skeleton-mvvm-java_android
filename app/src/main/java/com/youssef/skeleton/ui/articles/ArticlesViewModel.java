package com.youssef.skeleton.ui.articles;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.youssef.skeleton.data.remote.models.ArticlesResponse;
import com.youssef.skeleton.data.repository.DataManager;
import com.youssef.skeleton.di.component.ApiComponent;
import com.youssef.skeleton.di.component.DaggerApiComponent;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class ArticlesViewModel extends ViewModel {

    @Inject
    DataManager dataManager;

    final MutableLiveData<ArticlesResponse> articlesResponseMutableLiveData = new MutableLiveData<>();
    final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    final MutableLiveData<Boolean> errorMutableLiveData = new MutableLiveData<>();

    public ArticlesViewModel() {
        super();

        ApiComponent apiComponent = DaggerApiComponent.create();
        apiComponent.inject(this);

        fetchArticlesItems();
    }

    private void fetchArticlesItems() {
        loading.setValue(true);

        dataManager.getArticlesItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArticlesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArticlesResponse articlesResponse) {
                        loading.setValue(false);
                        errorMutableLiveData.setValue(false);
                        articlesResponseMutableLiveData.setValue(articlesResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loading.setValue(false);
                        errorMutableLiveData.setValue(true);
                        articlesResponseMutableLiveData.setValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    LiveData<ArticlesResponse> getArticlesItems() {
        return articlesResponseMutableLiveData;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    LiveData<Boolean> getError() {
        return errorMutableLiveData;
    }
}
