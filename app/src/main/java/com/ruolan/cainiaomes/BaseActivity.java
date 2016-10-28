package com.ruolan.cainiaomes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/10/28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initListener();
        initData();
    }

    /**
     * 填充数据  没有写成子类必须实现，因为有的子类是没有数据填充的，比如启动页面
     */
    public void initData() {


    }

    /**
     * 对于控件的监听
     */
    protected abstract void initListener();

    /**
     * 初始化布局控件
     */
    protected abstract void initView();

    /**
     * 对应的布局
     *
     * @return
     */
    protected abstract int getLayoutId();

}
