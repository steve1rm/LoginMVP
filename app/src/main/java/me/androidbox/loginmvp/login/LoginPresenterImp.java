package me.androidbox.loginmvp.login;

/**
 * Created by steve on 5/9/16.
 */
public class LoginPresenterImp implements LoginPresenterContract<LoginFragmentView>, LoginModelContract.OnLoginCompletedListener {

    private LoginModelImp mLoginModelImp;
    private LoginFragmentView mLoginFragmentView;

    public LoginPresenterImp() {
        mLoginModelImp = new LoginModelImp();
    }

    /*
     * LoginPresenterContact - implementation
     */

    @Override
    public void onAttachView(LoginFragmentView view) {
        this.mLoginFragmentView = view;
    }

    @Override
    public void onDestroy() {
        mLoginFragmentView = null;
    }

    @Override
    public void validateCredentials() {
        if(mLoginModelImp != null) {
            mLoginModelImp.login(mLoginFragmentView.getUsername(), mLoginFragmentView.getPassword(), LoginPresenterImp.this);
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
