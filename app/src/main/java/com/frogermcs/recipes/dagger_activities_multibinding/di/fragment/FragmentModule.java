package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class FragmentModule<T> {
    protected final T fragment;

    public FragmentModule(T fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    T provideFragment() {
        return fragment;
    }
}
