package me.androidbox.loginmvp.supportutils;

import me.androidbox.loginmvp.login.LoginFragmentView;
import android.widget.EditText;
/**
 * Created by steve on 7/14/16.
 */
public final class ViewLocator {

    public static EditText getTextEditor(LoginFragmentView fragment, int id) {
        return (EditText) fragment.getView().findViewById(id);
    }
}
