package vfa.gaunau.practice.presentation;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.hawk.Hawk;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import vfa.gaunau.practice.presentation.di.AppInjector;
import vfa.gaunau.practice.utils.AppLogger;

public class App extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> androidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        AppInjector.init(this);
        AppLogger.init();
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}
