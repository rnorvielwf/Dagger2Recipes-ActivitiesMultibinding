package com.frogermcs.recipes.dagger_activities_multibinding;

import android.app.Activity;
import android.content.Context;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.HasActivitySubcomponentBuilders;
import com.frogermcs.recipes.dagger_activities_multibinding.di.app.AppComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.app.DaggerAppComponent;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class TestMyApplication extends MyApplication {

    @Inject
    Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityComponentBuilders;

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static HasActivitySubcomponentBuilders get(Context context) {
        return ((HasActivitySubcomponentBuilders) context.getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

    void initComponent() {

    }

    @Override
    public ActivityComponentBuilder getActivityComponentBuilder(Class<? extends Activity> activityClass) {
        return activityComponentBuilders.get(activityClass).get();
    }
}