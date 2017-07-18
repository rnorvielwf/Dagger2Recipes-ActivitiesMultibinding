package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentScope;

import javax.inject.Inject;

@FragmentScope
class FragmentOnePresenter implements FragmentOneContract.Presenter {

    private FragmentOneContract.View view;
    private int subscribedCount = -1; // track configuration changes (for fun)
    private Utils utils;

    @Inject
    FragmentOnePresenter(Utils utils) {
        this.utils = utils;
    }

    @Override
    public void init() {
        if (view != null) {
            view.updateTextView(utils.getPresenterHardcodedText() + ", " + subscribedCount + " configuration change(s)");
        }
    }

    @Override
    public void subscribe(FragmentOneContract.View view) {
        this.view = view;
        subscribedCount++;
    }

    @Override
    public void unsubscribe() {
        view = null;
    }
}
