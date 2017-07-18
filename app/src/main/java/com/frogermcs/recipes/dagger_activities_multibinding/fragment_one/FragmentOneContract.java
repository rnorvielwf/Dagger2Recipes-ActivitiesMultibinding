package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

interface FragmentOneContract {

    interface View {
        void updateTextView(String text);
    }

    interface Presenter {
        void init();

        void subscribe(View view);

        void unsubscribe();
    }
}
