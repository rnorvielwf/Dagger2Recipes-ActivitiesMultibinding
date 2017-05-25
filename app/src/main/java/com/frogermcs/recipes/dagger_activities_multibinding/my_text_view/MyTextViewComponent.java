package com.frogermcs.recipes.dagger_activities_multibinding.my_text_view;

import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewModule;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewScope;

import dagger.Module;
import dagger.Subcomponent;

@ViewScope
@Subcomponent(
        modules = MyTextViewComponent.MyTextViewModule.class
)
public interface MyTextViewComponent extends ViewComponent<MyTextView> {

    @Subcomponent.Builder
    interface Builder extends ViewComponentBuilder<MyTextViewModule, MyTextViewComponent> {
    }

    @Module
    class MyTextViewModule extends ViewModule<MyTextView> {
        MyTextViewModule(MyTextView view) {
            super(view);
        }
    }
}
