package com.frogermcs.recipes.dagger_activities_multibinding.main_activity;

interface MainContract {

    interface View {
        void updateText(String text);
    }

    interface Presenter {
        void init();
    }
}
