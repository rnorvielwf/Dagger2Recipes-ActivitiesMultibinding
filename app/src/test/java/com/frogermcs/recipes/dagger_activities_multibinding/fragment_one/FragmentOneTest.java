package com.frogermcs.recipes.dagger_activities_multibinding.fragment_one;

import android.widget.TextView;

import com.frogermcs.recipes.dagger_activities_multibinding.ApplicationMock;
import com.frogermcs.recipes.dagger_activities_multibinding.BuildConfig;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.main_activity.MainActivityMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.assertEquals;

@Config(constants = BuildConfig.class,
        sdk = 16,
        packageName = "com.frogermcs.recipes.dagger_activities_multibinding",
        application = ApplicationMock.class)
@RunWith(RobolectricTestRunner.class)
public class FragmentOneTest {

    @Test
    public void checkTextView() {
        FragmentOne fragment = new FragmentOne();
        SupportFragmentTestUtil.startVisibleFragment(fragment, MainActivityMock.class, R.id.fragment1);
        assertEquals(Utils.TEXT, ((TextView) fragment.getView().findViewById(R.id.textView)).getText());
    }
}