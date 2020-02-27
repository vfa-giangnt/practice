package vfa.gaunau.practice.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;
import vfa.gaunau.practice.BuildConfig;

public class AppLogger {
    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new AppDebugTree());
        }
    }

    private static class AppDebugTree extends Timber.DebugTree {
        @Override
        protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
            return "(" + element.getFileName() + ":" + element.getLineNumber() + ")#" + element.getMethodName();
        }
    }
}
