package com.youssef.skeleton.di.component;


import com.youssef.skeleton.di.ApiModule;
import com.youssef.skeleton.ui.articles.ArticlesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(ArticlesViewModel articlesViewModel);
}
