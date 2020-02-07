package com.example.computer_ren.androidipc_demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {
    private List<Book> mBooks = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        mBooks.add(new Book("第一行代码",39));
        mBooks.add(new Book("第二行代码",49));
        mBooks.add(new Book("Android开发艺术探索",59));
    }

    private Binder mBinder = new BookManager.Stub() {

        @Override
        public List<Book> getBooks() throws RemoteException {
            return mBooks;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBooks.add(book);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG", "onUnbind: " );
        return super.onUnbind(intent);
    }
}
