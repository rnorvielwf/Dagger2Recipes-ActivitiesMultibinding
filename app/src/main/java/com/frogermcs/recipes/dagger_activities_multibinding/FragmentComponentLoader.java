package com.frogermcs.recipes.dagger_activities_multibinding;

import android.support.v4.content.Loader;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponent;

public class FragmentComponentLoader<C extends FragmentComponent, F extends BaseFragment<C>> extends Loader<C> {

    private C component;
    private F fragment;

    public FragmentComponentLoader(F fragment) {
        super(fragment.getContext());
        this.fragment = fragment;
    }

    @Override
    protected void onStartLoading() {
        if (component != null) {
            deliverResult(component);
        } else {
            forceLoad();
        }
    }

    @Override
    protected void onForceLoad() {
        deliverResult(fragment.createComponent());
    }

    @Override
    protected void onReset() {
        component = null;
    }
}
