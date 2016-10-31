package com.ruolan.cainiaomes;

import android.app.Application;
import android.content.Context;
import android.gesture.GestureOverlayView;
import android.provider.ContactsContract;

import com.google.gson.Gson;
import com.ruolan.cainiaomes.constant.Constants;
import com.ruolan.cainiaomes.entity.Profile;
import com.ruolan.cainiaomes.utils.SpUtils;

/**
 * Created by Administrator on 2016/10/28.
 */

public class MesApplicaption extends Application{


    private static MesApplicaption mContext;
    private static Profile sProfile;
    public static String selfId = null;
    private static int mAppState = -1;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mAppState = -1;

    }

    /**
     * 保存用户信息
     * @param profile
     */
    public static void setProfile(Profile profile){
        sProfile = profile;
        selfId = profile.getUserId();
        Gson gson = new Gson();
        SpUtils.getInstance(mContext).saveString(Constants.KEY_PROFILE,gson.toJson(profile));
    }

    /**
     * 获取本地保存的用户信息
     * @return
     */
    public static Profile getProfile(){
        return sProfile;
    }

    /**
     * 获取到token
     * @return
     */
    public static String getToken(){
        if (sProfile == null){
            return null;
        }
        return sProfile.getAccess_token();
    }

    /**
     * 初始化Profile
     */
    public static void initalizeProfile(){
        String json = SpUtils.getInstance(mContext).getString(Constants.KEY_PROFILE);
        Gson gson = new Gson();
        Profile profile = gson.fromJson(json,Profile.class);
        selfId = profile.getUserId();
    }
}
