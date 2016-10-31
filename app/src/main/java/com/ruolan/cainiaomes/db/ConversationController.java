package com.ruolan.cainiaomes.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.ruolan.cainiaomes.entity.Conversation;
import com.ruolan.cainiaomes.entity.Message;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/31.
 */

public class ConversationController {

    public static Dao<Conversation, String> getDao() throws SQLException {
        return DBController.getInstance().getOrmDBHelper().getDao(Conversation.class);
    }

    /**
     * 添加更新数据
     *
     * @param conversation 数据表
     */
    public static void addOrUpdate(Conversation conversation) {
        try {
            getDao().createOrUpdate(conversation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除数据
     *
     * @param conversation 数据表
     */
    public static void delete(Conversation conversation) {
        try {
            getDao().delete(conversation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询数据
     *
     * @param id id
     * @return 查询结果
     */
    public static Conversation queryById(String id) {
        try {
            return getDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有数据
     *
     * @return 集合
     */
    public static ArrayList<Conversation> queryAllByTimeDesc() {
        ArrayList<Conversation> conversations = new ArrayList<>();
        try {
            QueryBuilder<Conversation, String> queryBuilder = getDao().queryBuilder();
            queryBuilder.orderBy(Conversation.TIMESTAMP, false);
            conversations = (ArrayList<Conversation>) getDao().query(queryBuilder.prepare());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conversations;

    }

    public static void syncMessage(Message message) {
        addOrUpdate(message.copyTo());
    }

    /**
     * 更新是否阅读过
     * @param targetId  目标id
     */
    public static void markAsRead(String targetId) {
        try {
            getDao().updateRaw("UPDATE conversation SET" + Conversation.UNREADNUM + "=0 WHERE "
                    + Conversation.TARGETID + "=?", targetId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
