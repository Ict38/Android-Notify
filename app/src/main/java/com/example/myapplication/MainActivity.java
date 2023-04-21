package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=
                        BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,
                        MyNotification.CHANNEL_ID)
                        .setContentTitle("LAN mua hang")
                        .setContentText("Mua 2 ao khoac")
                        .setSmallIcon(R.drawable.ic_android_black_24dp)
                        .setColor(Color.RED)
                        .setLargeIcon(bitmap)
                        .setDefaults(NotificationCompat.DEFAULT_SOUND)
                        .setCategory(NotificationCompat.CATEGORY_ALARM);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
                managerCompat.notify(getId(), builder.build());
            }
        });
    }
    private int getId(){
        return (int) new Date().getTime();
    }
}