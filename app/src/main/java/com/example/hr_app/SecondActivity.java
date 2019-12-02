package com.example.hr_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {
    private Button Attendance;
    private Button Leave;
    private ImageButton Notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Notification=(ImageButton) findViewById(R.id.imageButton4);
        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,NotificationActivity.class);
                startActivity(intent);
            }
        });
        Attendance=(Button) findViewById(R.id.button2);
        Leave=(Button)findViewById(R.id.button3);
        Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,SecondSubActivity.class);
                startActivity(intent);
            }
        });
        Leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, LeaveActivity.class);
                startActivity(intent);
            }
        });
    }
}
