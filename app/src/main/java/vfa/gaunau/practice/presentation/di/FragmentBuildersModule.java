package vfa.gaunau.practice.presentation.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import vfa.gaunau.practice.presentation.ui.main.MainFragment;
import vfa.gaunau.practice.presentation.ui.splash.SplashFragment;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract SplashFragment contributeSplashFragment();

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();
}
