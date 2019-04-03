package com.youssef.skeleton.ui.articles;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.youssef.skeleton.R;
import com.youssef.skeleton.adapters.ArticlesAdapter;
import com.youssef.skeleton.databinding.FragmentArticlessBinding;
import com.youssef.skeleton.data.remote.models.ArticlesResponse;


public class ArticlesFragment extends Fragment {
    private FragmentArticlessBinding binding;
    private ArticlesAdapter adapter;
    private ArticlesViewModel articlesViewModel;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    public static ArticlesFragment newInstance() {
        return new ArticlesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articless, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        articlesViewModel = ViewModelProviders.of(this).get(ArticlesViewModel.class);

        articlesViewModel.getArticlesItems().observe(this, new Observer<ArticlesResponse>() {
            @Override
            public void onChanged(@Nullable ArticlesResponse articlesResponse) {
                if (articlesResponse != null)
                    showArticlesList(articlesResponse);
            }
        });


        articlesViewModel.getLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isLoading) {
                if (isLoading != null) {
                    binding.pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                }
            }
        });

        articlesViewModel.getError().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean error) {
                if (error == null || error)
                    Toast.makeText(getContext(), getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showArticlesList(ArticlesResponse articlesResponse) {
        if (articlesResponse != null && articlesResponse.getResults() != null && articlesResponse.getResults().size() > 0) {
            adapter = new ArticlesAdapter(articlesResponse.getResults());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            binding.customRecyclerView.setLayoutManager(layoutManager);
            binding.customRecyclerView.setAdapter(adapter);
        }
    }
}
