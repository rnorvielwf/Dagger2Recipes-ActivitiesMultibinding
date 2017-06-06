package com.frogermcs.recipes.dagger_activities_multibinding.main_activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.frogermcs.recipes.dagger_activities_multibinding.ApplicationMock;
import com.frogermcs.recipes.dagger_activities_multibinding.BuildConfig;
import com.frogermcs.recipes.dagger_activities_multibinding.R;
import com.frogermcs.recipes.dagger_activities_multibinding.Utils;
import com.frogermcs.recipes.dagger_activities_multibinding.di.fragment.FragmentComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.di.view.ViewComponentBuilder;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_one.FragmentOne;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_one.FragmentOneComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_two.FragmentTwo;
import com.frogermcs.recipes.dagger_activities_multibinding.fragment_two.FragmentTwoComponent;
import com.frogermcs.recipes.dagger_activities_multibinding.my_text_view.MyTextView;
import com.frogermcs.recipes.dagger_activities_multibinding.my_text_view.MyTextViewComponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class,
        sdk = 16,
        packageName = "com.frogermcs.recipes.dagger_activities_multibinding",
        application = ApplicationMock.class)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivityMock activity;
    ActivityController<MainActivityMock> controller;
    @Mock
    MainActivityComponent.Builder builder;
    @Mock
    Utils utilsMock;
    @Mock
    FragmentOneComponent.Builder fragmentOneComponentBuilder;
    @Mock
    FragmentTwoComponent.Builder fragmentTwoComponentBuilder;
    private Map<Class<? extends Fragment>, Provider<FragmentComponentBuilder>> fragmentComponentBuilders = new HashMap<>();
    @Mock
    MyTextViewComponent.Builder viewComponentBuilder;
    private Map<Class<? extends View>, Provider<ViewComponentBuilder>> viewComponentBuilders = new HashMap<>();

    private MainActivityComponent mainActivityComponent = new MainActivityComponent() {
        @Override
        public void injectMembers(MainActivity instance) {
            instance.mainActivityPresenter = new MainActivityPresenter(instance, utilsMock);
            instance.viewComponentBuilders = viewComponentBuilders;
        }
    };

    private FragmentOneComponent fragmentOneComponent = new FragmentOneComponent() {
        @Override
        public void injectMembers(FragmentOne instance) {
            instance.utils = utilsMock;
        }
    };

    private FragmentTwoComponent fragmentTwoComponent = new FragmentTwoComponent() {
        @Override
        public void injectMembers(FragmentTwo instance) {
        }
    };

    private MyTextViewComponent myTextViewComponent = new MyTextViewComponent() {
        @Override
        public void injectMembers(MyTextView instance) {
            instance.utils = utilsMock;
        }
    };

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(builder.build()).thenReturn(mainActivityComponent);
        when(builder.activityModule(any(MainActivityComponent.MainActivityModule.class))).thenReturn(builder);

        ApplicationMock app = (ApplicationMock) RuntimeEnvironment.application;
        app.putActivityComponentBuilder(builder, MainActivity.class);

        when(fragmentOneComponentBuilder.build()).thenReturn(fragmentOneComponent);
        when(fragmentOneComponentBuilder.fragmentModule(any(FragmentOneComponent.FragmentOneModule.class))).thenReturn(fragmentOneComponentBuilder);
        when(fragmentTwoComponentBuilder.build()).thenReturn(fragmentTwoComponent);
        when(fragmentTwoComponentBuilder.fragmentModule(any(FragmentTwoComponent.FragmentTwoModule.class))).thenReturn(fragmentTwoComponentBuilder);
        when(viewComponentBuilder.build()).thenReturn(myTextViewComponent);
        when(viewComponentBuilder.viewModule(any(MyTextViewComponent.MyTextViewModule.class))).thenReturn(viewComponentBuilder);

        controller = Robolectric.buildActivity(MainActivityMock.class);
        activity = controller.get();
        activity.putFragmentComponentBuilder(fragmentOneComponentBuilder, FragmentOne.class, fragmentComponentBuilders);
        activity.putFragmentComponentBuilder(fragmentTwoComponentBuilder, FragmentTwo.class, fragmentComponentBuilders);
        activity.putViewComponentBuilder(viewComponentBuilder, MyTextView.class, viewComponentBuilders);
    }

    @Test
    public void checkTextView() {
        String expectedText = "lorem ipsum";
        when(utilsMock.getHardcodedText()).thenReturn(expectedText);

        //MainActivity activity = Robolectric.setupActivity(TestMainActivity.class);
        //activity.onCreate(null);
        controller.create().start().resume().visible();
        assertEquals(expectedText, ((MyTextView) activity.findViewById(R.id.myTextView)).getText());
    }
}