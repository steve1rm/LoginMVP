package me.androidbox.loginmvp.login;

import android.content.Context;
import android.content.Loader;

/**
 * Created by steve on 6/7/16.
 */
public class PresenterLoader<T extends LoginPresenterContract> extends Loader<T> {
    private T mPresenterContract;
    private String mTag;
    private PresenterFactory<T> mPresenterFactory;

    public PresenterLoader(Context context, PresenterFactory<T> presenterFactory, String tag) {
        super(context);
        this.mPresenterFactory = presenterFactory;
        this.mTag = tag;
    }

    @Override
    protected void onStartLoading() {
        if(mPresenterContract != null) {
            deliverResult(mPresenterContract);
        }
        else {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
    }

    @Override
    protected void onForceLoad() {
        mPresenterContract = mPresenterFactory.createInstance();
    }

    @Override
    public void deliverResult(T data) {
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
    }
}
