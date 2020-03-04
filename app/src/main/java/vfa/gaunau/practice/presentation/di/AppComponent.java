package vfa.gaunau.practice.presentation.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import vfa.gaunau.practice.presentation.App;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuildersModule.class,
        FragmentBuildersModule.class,
        ViewModelModule.class,
        RepositoryModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
