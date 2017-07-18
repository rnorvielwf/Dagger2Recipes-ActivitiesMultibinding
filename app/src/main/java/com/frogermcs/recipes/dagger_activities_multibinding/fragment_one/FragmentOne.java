package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.frogermcs.recipes.dagger_activities_multibinding.BaseFragment;
import com.frogermcs.recipes.dagger_activities_multibinding.FragmentComponentLoader;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.HasFragmentSubcomponentBuilders;

import javax.inject.Inject;

public class FragmentOne extends BaseFragment<FragmentOneComponent>
        implements FragmentOneContract.View, LoaderManager.LoaderCallbacks<FragmentOneComponent> {

    private static final int LOADER_ID = 101;

    @Inject
    FragmentOnePresenter presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe(this);
        presenter.init();
    }

    @Override
    public FragmentOneComponent createComponent() {
        HasFragmentSubcomponentBuilders hasFragmentSubcomponentBuilders = (HasFragmentSubcomponentBuilders) getActivity();

        return ((FragmentOneComponent.Builder) hasFragmentSubcomponentBuilders
                .getFragmentComponentBuilder(FragmentOne.class))
                .fragmentModule(new FragmentOneComponent.FragmentOneModule(this))
                .build();
    }

    @Override
    public void updateTextView(String text) {
        ((TextView) getView().findViewById(R.id.textView)).setText(text);
    }

    @Override
    public Loader<FragmentOneComponent> onCreateLoader(int id, Bundle args) {
        return new FragmentComponentLoader<>(this);
    }

    @Override
    public void onLoadFinished(Loader<FragmentOneComponent> loader, FragmentOneComponent component) {
        component.injectMembers(this);
    }

    @Override
    public void onLoaderReset(Loader<FragmentOneComponent> loader) {
    }
}
