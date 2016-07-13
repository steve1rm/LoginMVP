package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public interface LoginFragmentViewContract {
    String getUsername();
    String getPassword();

    void onLoginSuccess();
    void onLoginFailed(String errorMessage);
}
