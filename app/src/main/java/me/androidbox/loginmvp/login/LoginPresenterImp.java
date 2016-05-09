package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public class LoginPresenterImp implements LoginPresenter, LoginModel.OnLoginCompletedListener {

    private LoginModelImp mLoginModelImp;
    private LoginFragmentView mLoginFragmentView;

    public LoginPresenterImp(LoginFragmentView loginFragmentView) {
        this.mLoginFragmentView = loginFragmentView;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void validateCredentials(String username, String password) {
        mLoginModelImp.login(username, password, LoginPresenterImp.this);
    }

    @Override
    public void onUsernameError() {
        mLoginFragmentView.onLoginFailed("Incorrect username");
    }

    @Override
    public void onPasswordError() {
        mLoginFragmentView.onLoginFailed("Incorrect password");
    }

    @Override
    public void onSuccess() {
        mLoginFragmentView.onLoginSuccess();
    }
}
