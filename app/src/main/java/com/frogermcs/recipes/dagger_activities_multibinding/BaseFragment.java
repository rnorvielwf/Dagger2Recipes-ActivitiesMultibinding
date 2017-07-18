package com.frogermcs.recipes.dagger_activities_multibinding;

import android.support.v4.app.Fragment;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponent;

public abstract class BaseFragment<T extends FragmentComponent> extends Fragment {

    public abstract T createComponent();
}
