package com.youssef.skeleton.data.remote;

import com.youssef.skeleton.data.remote.models.ArticlesResponse;

import retrofit2.http.GET;

/**
 * Created by Youssef.Waguih on 9/24/2018.
 */


public interface GetDataService {
    @GET("/svc/mostpopular//v2/viewed/1.json?api-key=IsDnmgfMSOpuJZnkqsnlJHeEAZnwzpvV")
    io.reactivex.Observable<ArticlesResponse> getArticlesItems();
}