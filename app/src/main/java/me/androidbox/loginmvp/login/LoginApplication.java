package me.androidbox.loginmvp.login;

import android.app.Application;

/**
 * Created by steve on 5/17/16.
 */
public abstract class LoginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    public abstract void init();
}
