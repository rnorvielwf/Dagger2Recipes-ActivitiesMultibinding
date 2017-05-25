package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

import android.view.View;

public interface HasViewSubcomponentBuilders {
    ViewComponentBuilder getViewComponentBuilder(Class<? extends View> viewClass);
}