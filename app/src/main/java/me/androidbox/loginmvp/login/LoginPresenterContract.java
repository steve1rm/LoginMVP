package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public interface LoginPresenterContract<LoginFragmentViewContract> {
    void validateCredentials();

    void attachView(LoginFragmentViewContract view);
    void detachView();
}
