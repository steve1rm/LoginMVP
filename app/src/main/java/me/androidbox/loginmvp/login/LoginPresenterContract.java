package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public interface LoginPresenterContract {
    void validateCredentials();

    void onDestroy();
}
