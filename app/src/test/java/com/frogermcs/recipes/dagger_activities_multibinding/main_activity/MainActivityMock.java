package com.frogermcs.recipes.dagger_activities_multibinding.main_activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewComponentBuilder;

import java.util.Map;

import javax.inject.Provider;

public class MainActivityMock extends MainActivity {

    public void putFragmentComponentBuilder(final FragmentComponentBuilder builder, Class<? extends Fragment> cls,
                                            Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentComponentBuilders) {
        if (this.fragmentComponentBuilders == null) {
            this.fragmentComponentBuilders = fragmentComponentBuilders;
        }

        this.fragmentComponentBuilders.put(cls, new Provider<FragmentComponentBuilder>() {
            @Override
            public FragmentComponentBuilder get() {
                return builder;
            }
        });
    }

    public void putViewComponentBuilder(final ViewComponentBuilder builder, Class<? extends View> cls,
                                        Map<Class<? extends View>, Provider<ViewComponentBuilder>> viewComponentBuilders) {
        if (this.viewComponentBuilders == null) {
            this.viewComponentBuilders = viewComponentBuilders;
        }

        viewComponentBuilders.put(cls, new Provider<ViewComponentBuilder>() {
            @Override
            public ViewComponentBuilder get() {
                return builder;
            }
        });
    }
}
