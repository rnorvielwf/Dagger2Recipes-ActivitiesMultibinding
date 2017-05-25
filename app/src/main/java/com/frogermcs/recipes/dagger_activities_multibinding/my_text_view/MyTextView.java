package com.frogermcs.recipes.dagger_activities_multibinding.my_text_view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.HasViewSubcomponentBuilders;

import javax.inject.Inject;

public class MyTextView extends AppCompatTextView {

    @Inject
    Utils utils;

    public MyTextView(Context context) {
        super(context);
        injectMembers(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        injectMembers(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        injectMembers(context);
    }

    private void injectMembers(Context context) {
        HasViewSubcomponentBuilders hasViewSubcomponentBuilders = ((HasViewSubcomponentBuilders) context);
        ((MyTextViewComponent.Builder) hasViewSubcomponentBuilders.getViewComponentBuilder(MyTextView.class))
                .viewModule(new MyTextViewComponent.MyTextViewModule(this))
                .build()
                .injectMembers(this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setText(utils.getHardcodedText());
    }
}
