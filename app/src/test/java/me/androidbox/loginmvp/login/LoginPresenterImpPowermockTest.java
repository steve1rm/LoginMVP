package me.androidbox.loginmvp.login;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by steve on 7/14/16.
 */
@PowerMockIgnore({"org.mockito.*", "android.*"})
@PrepareForTest(LoginModelContract.OnLoginCompletedListener.class)
public class LoginPresenterImpPowermockTest {

    @Rule
    public PowerMockRule powerMockRule = new PowerMockRule();
    private LoginModelContract.OnLoginCompletedListener mockEvents;

    public void setUp() throws Exception {
/*
        mockEvents = PowerMockito.spy(new LoginModelContract.OnLoginCompletedListener());

        PowerMockito.whenNew(LoginModelContract.OnLoginCompletedListener.class)
                .withNoArguments()
                .thenReturn(this.mockEvents);
*/
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidateCredentials() throws Exception {
        PowerMockito.verifyPrivate(mockEvents, times(1)).invoke("onSuccess");
    }
}