package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

import android.support.v4.app.Fragment;

public interface HasFragmentSubcomponentBuilders {
    FragmentComponentBuilder getFragmentComponentBuilder(Class<? extends Fragment> fragmentClass);
}