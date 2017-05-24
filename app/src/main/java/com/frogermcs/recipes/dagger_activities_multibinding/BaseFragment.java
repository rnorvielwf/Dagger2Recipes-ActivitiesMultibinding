package com.frogermcs.recipes.dagger_activities_multibinding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.HasFragmentSubcomponentBuilders;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
    }

    protected void setupFragmentComponent() {
        injectMembers((HasFragmentSubcomponentBuilders) getActivity());
    }

    protected abstract void injectMembers(HasFragmentSubcomponentBuilders hasFragmentSubcomponentBuilders);
}
