package com.ruolan.cainiaomes.db;

import com.j256.ormlite.dao.Dao;
import com.ruolan.cainiaomes.entity.Message;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/31.
 * 消息控制器
 */

public class MessageController {

    public static Dao<Message, String> getDao() throws SQLException {
        return DBController.getInstance().getOrmDBHelper().getDao(Message.class);
    }

    public static void addOrUpdate(Message message){
        try {
            getDao().createOrUpdate(message);
            ConversationController.syncMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
