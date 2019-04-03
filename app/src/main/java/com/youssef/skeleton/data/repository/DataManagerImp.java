package com.youssef.skeleton.data.repository;

import com.youssef.skeleton.data.remote.GetDataService;
import com.youssef.skeleton.data.remote.models.ArticlesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class DataManagerImp implements DataManager {
    GetDataService service;

    @Inject
    public DataManagerImp(GetDataService service) {
        this.service = service;
    }

    @Override
    public Observable<ArticlesResponse> getArticlesItems() {
        return service.getArticlesItems();
    }
}
