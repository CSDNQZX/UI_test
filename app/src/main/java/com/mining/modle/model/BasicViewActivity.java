package com.mining.modle.model;

import com.mining.modle.base.BaseActivity;

/**
 * Created by Administrator on 2019-4-24.
 */

public abstract class BasicViewActivity extends BaseActivity{
    private static final long serialVersionUID = -1425545734173327715L;

    public abstract void onSuccess(String code);

    public abstract void onErrors(String code);
}
