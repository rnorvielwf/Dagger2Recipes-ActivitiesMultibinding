package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

public interface FragmentComponentBuilder<M extends FragmentModule, C extends FragmentComponent> {
    FragmentComponentBuilder<M, C> fragmentModule(M fragmentModule);
    C build();
}