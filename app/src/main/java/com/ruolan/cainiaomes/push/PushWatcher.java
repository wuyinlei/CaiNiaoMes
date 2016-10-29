package com.ruolan.cainiaomes.push;

import com.ruolan.cainiaomes.entity.Message;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wuyinlei on 2016/10/29.
 */

public class PushWatcher implements Observer {


    @Override
    public void update(Observable o, Object data) {
        if (data instanceof  Message){
            messageUpdate((Message) data);
        }
    }

    public void messageUpdate(Message message){

    }
}
