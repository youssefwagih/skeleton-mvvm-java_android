package com.youssef.skeleton.data.repository;

import com.youssef.skeleton.data.remote.GetDataService;
import com.youssef.skeleton.data.remote.models.ArticlesResponse;
import com.youssef.skeleton.network.RetrofitClientInstance;

import io.reactivex.Observable;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class DataManagerImp implements DataManager {

    public DataManagerImp() {
    }

    @Override
    public Observable<ArticlesResponse> getArticlesItems() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        return service.getArticlesItems();
    }
}
