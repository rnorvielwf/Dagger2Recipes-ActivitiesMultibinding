package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

import android.view.View;

import dagger.MapKey;

@MapKey
@interface ViewKey {
    Class<? extends View> value();
}
