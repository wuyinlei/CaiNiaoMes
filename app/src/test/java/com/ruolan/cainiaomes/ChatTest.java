package com.ruolan.cainiaomes;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ruolan.cainiaomes.entity.Message;
import com.ruolan.cainiaomes.push.PushManager;
import com.ruolan.cainiaomes.push.PushWatcher;


/**
 * Created by wuyinlei on 2016/10/29.
 */

public class ChatTest extends AndroidTestCase {

    private static final String SELFID = "Mac";
    private static final String TARGETID = "Will";

    PushWatcher mWatcher1 = new PushWatcher(){
        @Override
        public void messageUpdate(Message message) {
            super.messageUpdate(message);
            Log.d("ChatTest", message.toString());
        }
    };
    PushWatcher mWatcher2 = new PushWatcher();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        PushManager.getInstance(getContext()).addObserver(mWatcher1);
    }

    public void testSendMsg() throws Exception{
        Message message = new Message();
        message.setId("00001");
        message.setSenderId(SELFID);
        message.setReeiverId(TARGETID);
        PushManager.getInstance(getContext()).sendMessage(message);
    }

    public void testReceiveMsg() throws Exception{
        PushManager.getInstance(getContext()).handlerPush("");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        PushManager.getInstance(getContext()).removeObserver(mWatcher1);
    }
}
