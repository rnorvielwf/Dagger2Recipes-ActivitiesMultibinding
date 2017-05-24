package com.frogermcs.recipes.dagger_activities_multibinding.main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.frogermcs.recipes.dagger_activities_multibinding.BaseActivity;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.HasActivitySubcomponentBuilders;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.HasFragmentSubcomponentBuilders;
import com.frogermcs.recipes.dagger_activities_multibinding.second_activity.SecondActivity;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class MainActivity extends BaseActivity implements HasFragmentSubcomponentBuilders {

    public MainActivityComponent activityComponent;

    @Inject
    MainActivityPresenter mainActivityPresenter;
    @Inject
    Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentComponentBuilders;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        mainActivityPresenter.init();
    }

    @Override
    protected void injectMembers(HasActivitySubcomponentBuilders hasActivitySubcomponentBuilders) {
        activityComponent = ((MainActivityComponent.Builder) hasActivitySubcomponentBuilders.getActivityComponentBuilder(MainActivity.class))
                .activityModule(new MainActivityComponent.MainActivityModule(this))
                .build();
        activityComponent.injectMembers(this);
    }

    public void openSecondScreen(View v) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void updateText(String text) {
        textView.setText(text);
    }

    @Override
    public FragmentComponentBuilder getFragmentComponentBuilder(Class<? extends Fragment> fragmentClass) {
        return fragmentComponentBuilders.get(fragmentClass).get();
    }
}
