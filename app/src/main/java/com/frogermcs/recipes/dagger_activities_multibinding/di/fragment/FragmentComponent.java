package com.frogermcs.recipes.dagger_activities_multibinding.di.fragment;

import android.support.v4.app.Fragment;

import dagger.MembersInjector;

public interface FragmentComponent<A extends Fragment> extends MembersInjector<A> {
}
