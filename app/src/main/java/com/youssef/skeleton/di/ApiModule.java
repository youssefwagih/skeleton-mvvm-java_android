package com.youssef.skeleton.di;

import com.youssef.skeleton.data.remote.GetDataService;
import com.youssef.skeleton.data.repository.DataManager;
import com.youssef.skeleton.data.repository.DataManagerImp;
import com.youssef.skeleton.network.RetrofitClientInstance;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class ApiModule {

    @Provides
    @Singleton
    GetDataService provideAPIService(Retrofit retrofit) {
        return retrofit.create(GetDataService.class);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return RetrofitClientInstance.getRetrofitInstance();
    }




    @Provides
    @Singleton
    DataManager provideDataManager(GetDataService service) {
        return new DataManagerImp(service);
    }
}
