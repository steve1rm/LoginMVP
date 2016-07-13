package me.androidbox.loginmvp.login;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.androidbox.loginmvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragmentView extends Fragment implements LoginFragmentViewContract {
    private static final String TAG = LoginFragmentView.class.getSimpleName();

    @BindView(R.id.etUsername) EditText mEtUsername;
    @BindView(R.id.etPassword) EditText mEtPassword;

    private LoginPresenterImp mLoginPresenterImp;

    public LoginFragmentView() {
        // Required empty public constructor
    }

    public static LoginFragmentView getInstance(int data) {
        Bundle bundle = new Bundle();
        bundle.putInt("DATA", data);

        LoginFragmentView sLoginFragmentView = new LoginFragmentView();
        sLoginFragmentView.setArguments(bundle);

        return sLoginFragmentView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(LoginFragmentView.this, view);

        Log.d(TAG, "Username: " + mEtUsername.getText().toString());

        mLoginPresenterImp = new LoginPresenterImp();
        mLoginPresenterImp.attachView(LoginFragmentView.this);

        return view;
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnSubmitLogin)
    public void submitLogin() {
        Log.d(TAG, "submitLogin");
        mLoginPresenterImp.validateCredentials();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public String getUsername() {
        return mEtUsername.getText().toString();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getActivity(), "onLoginSuccess", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        Toast.makeText(getActivity(), "onLoginFailed " + errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        mLoginPresenterImp.detachView();
        super.onDestroyView();
    }
}
