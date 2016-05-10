package me.androidbox.loginmvp.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by steve on 5/9/16.
 */
public class LoginModelImp implements LoginModelContract {
    @Override
    public void login(final String username,
                      final String password,
                      final OnLoginCompletedListener onLoginCompletedListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean hasSuccess = true;
                if(TextUtils.isEmpty(username)) {
                    onLoginCompletedListener.onUsernameError();
                    hasSuccess = false;
                }

                if(TextUtils.isEmpty(password)) {
                    onLoginCompletedListener.onPasswordError();
                    hasSuccess = false;
                }

                if(hasSuccess) {
                    onLoginCompletedListener.onSuccess();
                }
            }
        }, 3000); /* Wait 2 seconds */
    }
}
