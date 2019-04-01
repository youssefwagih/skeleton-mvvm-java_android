package com.youssef.skeleton.repository;

import android.arch.lifecycle.MutableLiveData;

import com.youssef.skeleton.repository.model.ArticlesResponse;

import retrofit2.Callback;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public interface DataManager {
    MutableLiveData<ArticlesResponse> getArticlesItems(Callback<ArticlesResponse> callback);
}
