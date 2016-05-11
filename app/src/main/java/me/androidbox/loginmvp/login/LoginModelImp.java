package me.androidbox.loginmvp.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by steve on 5/9/16.
 */
public class LoginModelImp implements LoginModelContract {

    /* Valid username and passwords */
    private static String validUsername = "steve";
    private static String validPassword = "1234";

    @Override
    public void login(final String username,
                      final String password,
                      final OnLoginCompletedListener onLoginCompletedListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean hasSuccess = true;

                if(TextUtils.isEmpty(username) || !username.equals(validUsername)) {
                    onLoginCompletedListener.onUsernameError();
                    hasSuccess = false;
                }

                if(TextUtils.isEmpty(password) || !password.equals(validPassword)) {
                    onLoginCompletedListener.onPasswordError();
                    hasSuccess = false;
                }

                if(hasSuccess) {
                    onLoginCompletedListener.onSuccess();
                }
            }
        }, 2000); /* Wait 2 seconds */
    }
}
