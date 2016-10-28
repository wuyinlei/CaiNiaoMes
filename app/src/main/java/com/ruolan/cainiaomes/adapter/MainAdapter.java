package com.ruolan.cainiaomes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ruolan.cainiaomes.ui.ChatFragment;
import com.ruolan.cainiaomes.ui.ContactFragment;
import com.ruolan.cainiaomes.ui.DiscoverFragment;
import com.ruolan.cainiaomes.ui.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new ChatFragment());
        fragments.add(new ContactFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new ProfileFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
