package me.androidbox.loginmvp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import me.androidbox.loginmvp.login.LoginFragmentView;
import me.androidbox.loginmvp.login.LoginFragmentViewContract;
import me.androidbox.loginmvp.login.LoginModelContract;
import me.androidbox.loginmvp.login.LoginPresenterContract;
import me.androidbox.loginmvp.login.LoginPresenterImp;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by steve on 7/13/16.
 */
public class LoginPresenterImpTest {
    private LoginFragmentViewContract mMockViewContract;
    private LoginModelContract mMockModelContract;
    private LoginModelContract.OnLoginCompletedListener mMockOnLoginCompletedListener;
    private LoginPresenterContract<LoginFragmentViewContract> mLoginPresenterContract;

    @Before
    public void setUp() throws Exception {
        mMockViewContract = Mockito.mock(LoginFragmentViewContract.class);
        mMockModelContract = Mockito.mock(LoginModelContract.class);
        mMockOnLoginCompletedListener = Mockito.mock(LoginModelContract.OnLoginCompletedListener.class);
        mLoginPresenterContract = new LoginPresenterImp(mMockModelContract);
        mLoginPresenterContract.attachView(mMockViewContract);
    }

    @After
    public void tearDown() throws Exception {
        mLoginPresenterContract = null;
        mMockModelContract = null;
        mMockViewContract = null;
    }

    @Test
    public void shouldHaveNoInteractions() {
        verifyZeroInteractions(mMockViewContract);
    }

    @Test
    public void shouldIfNoUsernameOrPassword() {
        when(mMockViewContract.getUsername()).thenReturn("steve");
        when(mMockViewContract.getPassword()).thenReturn("1234");

        mLoginPresenterContract.validateCredentials();

        verify(mMockViewContract, times(1)).getUsername();
        verify(mMockViewContract, times(1)).getPassword();
    }

    @Test
    public void testValidateCredentials() {
        when(mMockViewContract.getUsername()).thenReturn("steve");
        when(mMockViewContract.getPassword()).thenReturn("1234");

        mLoginPresenterContract.validateCredentials();

        verify(mMockViewContract, times(1)).getUsername();
        verify(mMockViewContract, times(1)).getPassword();

        verify(mMockOnLoginCompletedListener, times(0)).onSuccess();

        verify(mMockOnLoginCompletedListener, times(1)).onPasswordError();
        verify(mMockOnLoginCompletedListener, times(1)).onUsernameError();
    }

    @Test
    public void testOnUsernameError() {

    }

    @Test
    public void testOnPasswordError() {

    }

    @Test
    public void testOnSuccess() {

    }
}