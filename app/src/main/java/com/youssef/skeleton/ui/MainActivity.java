package com.youssef.skeleton.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.youssef.skeleton.R;
import com.youssef.skeleton.ui.articles.ArticlesFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.screenContainer, ArticlesFragment.newInstance()).commit();
    }
}
