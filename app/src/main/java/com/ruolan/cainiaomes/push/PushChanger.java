package com.ruolan.cainiaomes.push;

import com.ruolan.cainiaomes.entity.Message;

import java.util.Observable;

/**
 * Created by wuyinlei on 2016/10/29.
 */

public class PushChanger extends Observable {

    private static PushChanger mPushChanger;

    public static PushChanger getInstance(){
        if (mPushChanger == null){
            mPushChanger = new PushChanger();
        }
        return mPushChanger;
    }

    /**
     * 更新数据
     * @param message
     */
    public void notifyChanged(Message message) {
        setChanged();
        notifyObservers(message);
    }
}
