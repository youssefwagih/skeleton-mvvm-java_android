package com.youssef.skeleton.repository;

import android.arch.lifecycle.MutableLiveData;

import com.youssef.skeleton.network.RetrofitClientInstance;
import com.youssef.skeleton.repository.model.ArticlesResponse;
import com.youssef.skeleton.repository.remote.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public class DataManagerImp implements DataManager {

    public DataManagerImp() {
    }

    @Override
    public MutableLiveData<ArticlesResponse> getArticlesItems(Callback<ArticlesResponse> callback) {
        final MutableLiveData<ArticlesResponse> articlesResponseMutableLiveData = new MutableLiveData<>();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ArticlesResponse> call = service.getArticlesItems();
        call.enqueue(callback);

        return articlesResponseMutableLiveData;
    }
}
