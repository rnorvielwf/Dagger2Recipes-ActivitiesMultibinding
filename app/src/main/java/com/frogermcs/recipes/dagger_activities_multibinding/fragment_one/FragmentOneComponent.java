package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentModule;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentScope;

import dagger.Module;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(
        modules = FragmentOneComponent.FragmentOneModule.class
)
public interface FragmentOneComponent extends FragmentComponent<FragmentOne> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<FragmentOneModule, FragmentOneComponent> {
    }

    @Module
    class FragmentOneModule extends FragmentModule<FragmentOne> {
        FragmentOneModule(FragmentOne fragment) {
            super(fragment);
        }
    }
}
