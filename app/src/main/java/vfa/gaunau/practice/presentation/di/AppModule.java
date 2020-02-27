package vfa.gaunau.practice.presentation.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import vfa.gaunau.practice.BuildConfig;

@Module
public class AppModule {

    // Lúc nào cũng lấy đc context của toàn bộ application
    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("practice", Context.MODE_PRIVATE);
    }

    Storage provideStorage() {
        return new HawkStorage();
    }


}
