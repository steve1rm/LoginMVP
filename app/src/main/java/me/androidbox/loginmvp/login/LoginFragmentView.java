package me.androidbox.loginmvp.login;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.androidbox.loginmvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragmentView extends Fragment implements LoginFragmentViewContract {


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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        LoginPresenterImp loginPresenterImp = new LoginPresenterImp(LoginFragmentView.this);

        loginPresenterImp.validateCredentials("steve", "1234");

        return view;
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getActivity(), "onLoginSuccess", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        Toast.makeText(getActivity(), "onLoginFailed", Toast.LENGTH_LONG).show();
    }
}
