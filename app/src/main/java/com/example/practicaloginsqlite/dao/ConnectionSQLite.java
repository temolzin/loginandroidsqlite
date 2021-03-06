package com.example.practicaloginsqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionSQLite extends SQLiteOpenHelper {

    public ConnectionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.CREATE_TABLE_USER);
        db.execSQL(RolUserDAO.CREATE_TABLE_ROL_USER);
        db.execSQL(AccessDAO.CREATE_TABLE_ACCESS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS ROLUSER");
        db.execSQL("DROP TABLE IF EXISTS ACCESS");
        onCreate(db);
    }
}
