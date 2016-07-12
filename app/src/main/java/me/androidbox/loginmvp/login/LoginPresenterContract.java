package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public interface LoginPresenterContract<V> {
    void validateCredentials();
    void onAttachView(V view);
    void onDestroy();
}
