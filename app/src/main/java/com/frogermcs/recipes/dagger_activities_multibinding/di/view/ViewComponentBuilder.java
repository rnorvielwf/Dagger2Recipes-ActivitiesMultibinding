package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

public interface ViewComponentBuilder<M extends ViewModule, C extends ViewComponent> {
    ViewComponentBuilder<M, C> viewModule(M viewModule);
    C build();
}