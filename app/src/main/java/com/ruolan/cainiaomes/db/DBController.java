package com.ruolan.cainiaomes.db;

import android.hardware.camera2.DngCreator;

import com.ruolan.cainiaomes.MesApplicaption;

/**
 * Created by Administrator on 2016/10/31.
 */

public class DBController {

    private static DBController mInstance;
    private OrmDBHelper mOrmDBHelper;

    public DBController() {
        mOrmDBHelper = new OrmDBHelper(MesApplicaption.mContext);
    }

    public static DBController getInstance() {
        synchronized (DBController.class) {
            if (mInstance == null) {
                mInstance = new DBController();
            }
            return mInstance;
        }
    }

    public OrmDBHelper getOrmDBHelper(){
        return mOrmDBHelper;
    }
}
