package com.example.computer_ren.androidipc_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "student_provider.db";
    public static final String STUDENT_TABLE_NAME = "student";
    private static final int DB_VERSION = 1;
    private String mCreateTable = "create table if not exists "+STUDENT_TABLE_NAME+"(id integer primary key," + "name TEXT,"/*+"age INTEGER,"*/+"sex TEXT)";


    public DBOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
