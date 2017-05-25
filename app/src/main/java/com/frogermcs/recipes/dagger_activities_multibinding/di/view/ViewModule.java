package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModule<T> {
    protected final T view;

    public ViewModule(T view) {
        this.view = view;
    }

    @Provides
    @ViewScope
    T provideView() {
        return view;
    }
}
