package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

import android.support.v4.app.Fragment;

import dagger.MapKey;

@MapKey
@interface FragmentKey {
    Class<? extends Fragment> value();
}
