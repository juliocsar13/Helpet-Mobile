package com.kincodi.helpet.helpetmobile.presentation.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kincodi.helpet.helpetmobile.R;
import com.kincodi.helpet.helpetmobile.domain.executor.impl.ThreadExecutor;
import com.kincodi.helpet.helpetmobile.domain.interactors.GetInfoInteractor;
import com.kincodi.helpet.helpetmobile.domain.model.Post;
import com.kincodi.helpet.helpetmobile.presentation.presenters.GetPostInfoPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.LoginUserPresenter;
import com.kincodi.helpet.helpetmobile.presentation.presenters.impl.Post.GetPostInfoPresenterImpl;
import com.kincodi.helpet.helpetmobile.presentation.ui.adapter.PetFragmentPageAdapter;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail.InfoFragment;
import com.kincodi.helpet.helpetmobile.presentation.ui.fragments.Detail.MapFragment;
import com.kincodi.helpet.helpetmobile.storage.PostRepositoryImpl;
import com.kincodi.helpet.helpetmobile.threading.MainThreadImpl;

public class DetailActivity extends AppCompatActivity {

    ViewPager mViewPager;
    PetFragmentPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mViewPager = findViewById(R.id.pager);
        setupViewPager(mViewPager);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new PetFragmentPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new InfoFragment(), getString(R.string.title_info));
        adapter.addFragment(new MapFragment(), getString(R.string.title_map));
        viewPager.setAdapter(adapter);
    }

}
