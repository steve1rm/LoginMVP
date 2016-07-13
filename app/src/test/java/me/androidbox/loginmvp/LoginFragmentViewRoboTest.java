package me.androidbox.loginmvp;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.FragmentTestUtil;

import me.androidbox.loginmvp.login.LoginFragmentView;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by steve on 7/13/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginFragmentViewRoboTest {

    private LoginFragmentView mLoginFragmentView;

    @Before
    public void setup() throws Exception {
        mLoginFragmentView = new LoginFragmentView();

        FragmentTestUtil.startFragment(mLoginFragmentView);
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mLoginFragmentView);
    }

    @Test
    public void shouldHaveTitle() throws Exception {
        assertThat(mLoginFragmentView.getActivity().getTitle().toString(),
                equalTo(RuntimeEnvironment.application.getString(R.string.app_name)));

        EditText etUsername = (EditText)mLoginFragmentView.getView().findViewById(R.id.etUsername);
        assertNotNull(etUsername);
    }
}