package com.frogermcs.recipes.dagger_activities_multibinding.fragment_two;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentModule;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentScope;

import dagger.Module;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(
        modules = FragmentTwoComponent.FragmentTwoModule.class
)
public interface FragmentTwoComponent extends FragmentComponent<FragmentTwo> {

    @Subcomponent.Builder
    interface Builder extends FragmentComponentBuilder<FragmentTwoModule, FragmentTwoComponent> {
    }

    @Module
    class FragmentTwoModule extends FragmentModule<FragmentTwo> {
        FragmentTwoModule(FragmentTwo fragment) {
            super(fragment);
        }
    }
}
