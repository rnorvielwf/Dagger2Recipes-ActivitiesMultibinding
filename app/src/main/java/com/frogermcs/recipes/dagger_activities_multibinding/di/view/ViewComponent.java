package com.frogermcs.recipes.dagger_activities_multibinding.di.view;

import android.view.View;

import dagger.MembersInjector;

public interface ViewComponent<A extends View> extends MembersInjector<A> {
}
