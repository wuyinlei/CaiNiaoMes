package com.ruolan.cainiaomes.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.ruolan.cainiaomes.constant.Constants;
import com.ruolan.cainiaomes.entity.Message;

import static com.ruolan.cainiaomes.R.id.image;


/**
 * Created by wuyinlei on 2016/10/29.
 */

public class PushService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Message message = (Message) intent.getSerializableExtra(Constants.KEY_MESSAGE);
        switch (message.getType()) {
//            case plain:
//                sendPlainMsg(message);
//                break;
//            case image:
//                sendImageMsg(message);
//                break;
//
//            case audio:
//                sendAudioMsg(message);
//                break;
//            case emo:
//                sendEmoMsg(message);
//                break;
//            case location:
//                sendLocationMsg(message);
              //  break;


        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendLocationMsg(Message message) {


    }

    private void sendEmoMsg(Message message) {


    }

    private void sendAudioMsg(Message message) {

    }

    private void sendImageMsg(Message message) {


    }

    private void sendPlainMsg(Message message) {

    }
}
