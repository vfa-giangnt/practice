package vfa.gaunau.practice.presentation.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import vfa.gaunau.practice.presentation.ui.MainActivity;

@Module(includes = {AndroidSupportInjectionModule.class})
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();
}
