package com.frogermcs.recipes.dagger_activities_multibinding.fragment_two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frogermcs.recipes.dagger_activities_multibinding.BaseFragment;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.HasFragmentSubcomponentBuilders;

public class FragmentTwo extends BaseFragment<FragmentTwoComponent> {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public FragmentTwoComponent createComponent() {
        // There aren't actually any dependencies in this class ...
        HasFragmentSubcomponentBuilders hasFragmentSubcomponentBuilders = (HasFragmentSubcomponentBuilders) getActivity();

        return ((FragmentTwoComponent.Builder) hasFragmentSubcomponentBuilders
                .getFragmentComponentBuilder(FragmentTwo.class))
                .fragmentModule(new FragmentTwoComponent.FragmentTwoModule(this))
                .build();
    }
}
