package com.example.selfdrivingcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Thread.sleep;

public class Security_Activity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter = 5;
    private int timer = 10;

    private Handler customHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_);


        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("Please Login To Use Application!!! 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Ha Dep Trai")) && (userPassword.equals("hahaha"))) {
            Intent intent = new Intent(Security_Activity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Counter--;

            Info.setText("Please Login To Use Application!!!" + String.valueOf(Counter));
            if (Counter == 0) {
                Login.setEnabled(false);
                new CountDownTimer(11000, 1000) {
                    public void onTick(long millisUntilFinished) {
//                        int timer;
                        Info.setText("Please wait " + Integer.toString(timer));
                        timer--;
                    }

                    public void onFinish() {
                        timer = 10;
                        Counter = 6;
                        Login.setEnabled(true);
                    }
                }.start();
            }
        }

    }
}