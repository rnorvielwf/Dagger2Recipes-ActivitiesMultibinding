package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

import com.frogermcs.recipes.dagger_activities_multibinding.fragment_one.FragmentOne;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_one.FragmentOneComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_two.FragmentTwo;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_two.FragmentTwoComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(
        subcomponents = {
                FragmentOneComponent.class,
                FragmentTwoComponent.class
        })
public abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(FragmentOne.class)
    public abstract FragmentComponentBuilder fragmentOneComponentBuilder(FragmentOneComponent.Builder impl);

    @Binds
    @IntoMap
    @FragmentKey(FragmentTwo.class)
    public abstract FragmentComponentBuilder fragmentTwoComponentBuilder(FragmentTwoComponent.Builder impl);
}