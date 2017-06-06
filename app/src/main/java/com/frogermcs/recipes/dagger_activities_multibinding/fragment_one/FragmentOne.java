package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frogermcs.recipes.dagger_activities_multibinding.BaseFragment;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.HasFragmentSubcomponentBuilders;

import javax.inject.Inject;

public class FragmentOne extends BaseFragment {

    @Inject
    public Utils utils;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(utils.getHardcodedText());

        return view;
    }

    @Override
    protected void injectMembers(HasFragmentSubcomponentBuilders hasFragmentSubcomponentBuilders) {
        ((FragmentOneComponent.Builder) hasFragmentSubcomponentBuilders.getFragmentComponentBuilder(FragmentOne.class))
                .fragmentModule(new FragmentOneComponent.FragmentOneModule(this))
                .build()
                .injectMembers(this);
    }
}
