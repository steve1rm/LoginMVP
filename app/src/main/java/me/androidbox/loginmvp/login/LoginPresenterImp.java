package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public class LoginPresenterImp implements LoginPresenterContract<LoginFragmentViewContract>, LoginModelContract.OnLoginCompletedListener {

    private LoginModelContract mLoginModelContract;
    private LoginFragmentViewContract mLoginFragmentView;

    public LoginPresenterImp() {
        mLoginModelContract = new LoginModelImp();
    }

    /* Testing Only */
    public LoginPresenterImp(LoginModelContract loginModelContract) {
        mLoginModelContract = loginModelContract;
    }

    /*
     * LoginPresenterContact - implementation
     */
    @Override
    public void attachView(LoginFragmentViewContract view) {
        mLoginFragmentView = view;
    }

    @Override
    public void detachView() {
        mLoginFragmentView = null;
    }

    @Override
    public void validateCredentials() {
        if(mLoginModelContract != null) {
            mLoginModelContract.login(
                    mLoginFragmentView.getUsername(),
                    mLoginFragmentView.getPassword(),
                    LoginPresenterImp.this);
        }
    }

    /*
     * LoginModelContract.OnLoginCompletedListener - implementation
     */
    @Override
    public void onUsernameError() {
        if(mLoginFragmentView != null) {
            mLoginFragmentView.onLoginFailed("Incorrect username");
        }
    }

    @Override
    public void onPasswordError() {
        if(mLoginFragmentView != null) {
            mLoginFragmentView.onLoginFailed("Incorrect password");
        }
    }

    @Override
    public void onSuccess() {
        if(mLoginFragmentView != null) {
            mLoginFragmentView.onLoginSuccess();
        }
    }
}
