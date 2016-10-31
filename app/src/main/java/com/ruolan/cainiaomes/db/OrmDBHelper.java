package com.ruolan.cainiaomes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ruolan.cainiaomes.entity.Conversation;
import com.ruolan.cainiaomes.entity.Message;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/10/31.
 * 创建数据库
 */

public class OrmDBHelper extends OrmLiteSqliteOpenHelper {

    public static final String DB_NAME = "chat4it"; //数据库名字
    public static final int DB_VERSION = 1; //数据库版本

    public OrmDBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    public OrmDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.clearTable(connectionSource, Message.class);
            TableUtils.clearTable(connectionSource, Conversation.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
