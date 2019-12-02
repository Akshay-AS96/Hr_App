package com.example.hr_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    private EditText UserName;
    private EditText Password;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton() {
        UserName = (EditText) findViewById(R.id.editText3);
        Password = (EditText) findViewById(R.id.editText2);
        Login = (Button) findViewById(R.id.button);

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String validPassword=("^" +
                        "(?=.*[a-zA-Z])" +
                        "(?=\\s+$)" +
                        ".{6,}" +
                        "$");


                SecondActivity();
            }
        });

    }



    public void SecondActivity() {
        if (UserName.getText().toString().equals("user") && Password.getText().toString().equals("pass")) {
            Toast.makeText(MainActivity.this,"user and password is correct",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, DrawerMainActivity.class);
            startActivity(intent);
            finish();

        }
        else {
            Toast.makeText(MainActivity.this,"user and password is not correct",Toast.LENGTH_SHORT).show();

        }
        String suser=UserName.getText().toString();
        String spassword=Password.getText().toString();
        if(TextUtils.isEmpty(suser)) {
            UserName.setError("ENTER USERNAME");
        }
        if(TextUtils.isEmpty(spassword)) {
            Password.setError("ENTER PASSWORD");
        }



    }


}
