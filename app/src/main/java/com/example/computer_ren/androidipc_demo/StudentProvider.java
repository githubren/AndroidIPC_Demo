package com.example.computer_ren.androidipc_demo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class StudentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.computer_ren.androidipc_demo.StudentProvider";
    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private SQLiteDatabase mDB;
    private Context mContext;
    private String mTable;

    @Nullable
    @Override
    public Bundle call(@NonNull String method, @Nullable String arg, @Nullable Bundle extras) {

        return super.call(method, arg, extras);
    }

    static {
        mUriMatcher.addURI(AUTHORITY,"sudent",0);
    }

    @Override
    public boolean onCreate() {
        mTable = DBOpenHelper.STUDENT_TABLE_NAME;
        mContext =  getContext();
        initProvider();
        return false;
    }

    private void initProvider() {
        mDB = new DBOpenHelper(mContext).getWritableDatabase();
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String table = DBOpenHelper.STUDENT_TABLE_NAME;
        Cursor mCursor = mDB.query(table,projection,selection,selectionArgs,null,sortOrder,null);
        return mCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        mDB.insert(mTable,null,values);
        mContext.getContentResolver().notifyChange(uri,null);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return mDB.delete(DBOpenHelper.STUDENT_TABLE_NAME,selection,selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return mDB.update(DBOpenHelper.STUDENT_TABLE_NAME,values,selection,selectionArgs);
    }
}
