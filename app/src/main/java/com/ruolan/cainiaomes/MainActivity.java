package com.ruolan.cainiaomes;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.ruolan.cainiaomes.adapter.MainAdapter;
import com.ruolan.cainiaomes.utils.TranslucentUtils;
import com.ruolan.cainiaomes.widget.AddPopupWindow;
import com.ruolan.cainiaomes.widget.AlphaIndicator;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvAdd, mIvSearch;


    @Override
    protected void initListener() {
        mIvAdd.setOnClickListener(this);
        mIvSearch.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        TranslucentUtils.setColor(this, getResources().getColor(R.color.common_top_bar_blue), 1);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        AlphaIndicator alphaIndicator = (AlphaIndicator) findViewById(R.id.alphaIndicator);
        alphaIndicator.setViewPager(viewPager);

        mIvAdd = (ImageView) findViewById(R.id.iv_add);
        mIvSearch = (ImageView) findViewById(R.id.iv_search);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_add:
                showPop(v);
                break;
            case R.id.iv_search:

                break;
        }
    }

    private void showPop(View view) {
        AddPopupWindow popupWindow = new AddPopupWindow(this);
        popupWindow.showAsDropDown(view);

    }
}
