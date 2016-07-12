package me.androidbox.loginmvp.login;

/**
 * Created by steve on 6/7/16.
 */
public interface PresenterFactory<T extends LoginPresenterContract> {
    T createInstance();
}
