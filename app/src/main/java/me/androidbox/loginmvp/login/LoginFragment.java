package me.androidbox.loginmvp.login;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.androidbox.loginmvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance(int data) {
        Bundle bundle = new Bundle();
        bundle.putInt("DATA", data);

        LoginFragment sLoginFragment = new LoginFragment();
        sLoginFragment.setArguments(bundle);

        return sLoginFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

}
