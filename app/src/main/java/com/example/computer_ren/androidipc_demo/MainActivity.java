package com.example.computer_ren.androidipc_demo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button intentBtn;
    private Button aidlBtn;
    private Button broadCastBtn;
    private Button contentproviderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        intentBtn = findViewById(R.id.btn_intent);
        aidlBtn = findViewById(R.id.btn_aidl);
        broadCastBtn = findViewById(R.id.btn_broadcast);
        contentproviderBtn = findViewById(R.id.btn_contentprovider);

        intentBtn.setOnClickListener(this);
        aidlBtn.setOnClickListener(this);
        broadCastBtn.setOnClickListener(this);
        contentproviderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_intent:
                Intent intent = new Intent();
//                intent.setAction("com.example.computer_ren.otherapplication");
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                ComponentName componentName = new ComponentName("com.example.computer_ren.otherapplication",
                        "com.example.computer_ren.otherapplication.MainActivity");
                intent.setComponent(componentName);
                startActivity(intent);
                break;
            case R.id.btn_aidl:

                break;
            case R.id.btn_broadcast:
                Intent intent1 = new Intent();
                intent1.setAction("com.example.computer_ren.otherapplication.BroadCast");
                intent1.setPackage("com.example.computer_ren.otherapplication");
                intent1.putExtra("data","你好，我是服务器");
                sendBroadcast(intent1);
                break;
            case R.id.btn_contentprovider:
                Intent intentContentProvider = new Intent();
                intentContentProvider.setClassName("com.example.computer_ren.otherapplication",
                        "com.example.computer_ren.otherapplication.ContentProviderActivitty");
                startActivity(intentContentProvider);
                break;
        }
    }
}
