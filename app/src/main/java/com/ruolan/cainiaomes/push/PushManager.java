package com.ruolan.cainiaomes.push;

import android.content.Context;
import android.content.Intent;

import com.ruolan.cainiaomes.constant.Constants;
import com.ruolan.cainiaomes.entity.Message;

/**
 * Created by wuyinlei on 2016/10/29.
 */

public class PushManager {

    private static PushManager mInstance;

    public Context mContext;

    public PushManager(Context context){

    }

    public static PushManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new PushManager(context);
        }
        return mInstance;
    }

    public void handlerPush(String content){
        // TODO: 2016/10/29  parse  content to  message/notice
        Message message = new Message();
        PushChanger.getInstance().notifyChanged(message);

    }

    public void sendMessage(Message message){
//        Intent intent = new Intent(mContext,PushService.class);
//        intent.putExtra(Constants.KEY_MESSAGE,message);
//        mContext.startService(intent);
        message.setStatue(Message.StatusType.ing);
        PushChanger.getInstance().notifyChanged(message);
        message.setStatue(Message.StatusType.done);
        PushChanger.getInstance().notifyChanged(message);
    }

    public void addObserver(PushWatcher whater){
        PushChanger.getInstance().addObserver(whater);
    }

    public void removeObserver(PushWatcher whater){
        PushChanger.getInstance().deleteObserver(whater);
    }

    public void removeOnservers(){
        PushChanger.getInstance().deleteObservers();
    }


}
