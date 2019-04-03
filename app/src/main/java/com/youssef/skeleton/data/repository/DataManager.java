package com.youssef.skeleton.data.repository;

import com.youssef.skeleton.data.remote.models.ArticlesResponse;

import io.reactivex.Observable;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */

public interface DataManager {
    Observable<ArticlesResponse> getArticlesItems();
}
