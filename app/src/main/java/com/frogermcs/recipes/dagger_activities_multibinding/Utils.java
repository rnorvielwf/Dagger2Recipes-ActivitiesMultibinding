package com.frogermcs.recipes.dagger_activities_multibinding;

import com.frogermcs.recipes.dagger_activities_multibinding.di.activity.ActivityScope;

import javax.inject.Inject;

/**
 * Created by froger_mcs on 18/10/2016.
 */

@ActivityScope
public class Utils {

    @Inject
    public Utils() {
    }

    public String getHardcodedText() {
        return "hardcoded text";
    }

    public String getPresenterHardcodedText() {
        return "presenter hardcoded text";
    }
}
