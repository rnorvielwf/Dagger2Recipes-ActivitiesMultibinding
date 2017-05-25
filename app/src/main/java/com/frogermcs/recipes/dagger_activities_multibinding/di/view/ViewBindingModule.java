package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

import com.frogermcs.recipes.dagger_activities_multibinding.my_text_view.MyTextView;
import com.frogermcs.recipes.dagger_activities_multibinding.my_text_view.MyTextViewComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(
        subcomponents = {
                MyTextViewComponent.class
        })
public abstract class ViewBindingModule {

    @Binds
    @IntoMap
    @ViewKey(MyTextView.class)
    public abstract ViewComponentBuilder myTextViewComponentBuilder(MyTextViewComponent.Builder impl);
}