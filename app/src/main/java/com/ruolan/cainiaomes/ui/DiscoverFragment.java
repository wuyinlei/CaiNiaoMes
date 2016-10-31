package com.ruolan.cainiaomes.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;

import com.ruolan.cainiaomes.BaseFragment;
import com.ruolan.cainiaomes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment implements View.OnClickListener {




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        mReFriends = (RelativeLayout) view.findViewById(R.id.re_friends);
        mReSaoyisao = (RelativeLayout) view.findViewById(R.id.re_saoyisao);
        mReYaoyiyao = (RelativeLayout) view.findViewById(R.id.re_yaoyiyao);
        mReFujin = (RelativeLayout) view.findViewById(R.id.re_fujin);
        mReGouwu = (RelativeLayout) view.findViewById(R.id.re_gouwu);
        mRePiaoliuping = (RelativeLayout) view.findViewById(R.id.re_piaoliuping);
        mReYouxi = (RelativeLayout) view.findViewById(R.id.re_youxi);

    }

    @Override
    protected void setListener() {
        mReFriends.setOnClickListener(this);
    }

    RelativeLayout mReFriends;
    RelativeLayout mReSaoyisao;
    RelativeLayout mReYaoyiyao;
    RelativeLayout mReFujin;
    RelativeLayout mRePiaoliuping;
    RelativeLayout mReGouwu;
    RelativeLayout mReYouxi;


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.re_friends:

                break;

            case R.id.re_saoyisao:

                break;

            case R.id.re_yaoyiyao:

                break;

            case R.id.re_fujin:

                break;

            case R.id.re_gouwu:

                break;

            case R.id.re_piaoliuping:

                break;

            case R.id.re_youxi:

                break;

        }
    }
}
