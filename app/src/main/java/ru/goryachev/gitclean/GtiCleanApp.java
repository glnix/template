package ru.goryachev.gitclean;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by ubuntudev on 05.05.17.
 */

public class GtiCleanApp extends Application {

    private static GtiCleanApp app;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        app = this;
    }

    public static GtiCleanApp getApplication() {
        return app;
    }
}
