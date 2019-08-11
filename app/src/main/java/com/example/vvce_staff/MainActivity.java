package com.example.vvce_staff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText emailEt,passEt;
    RadioGroup usersRg;
    Button loginBtn,registerBtn,signInBtn;
    private String emailId,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEt = findViewById(R.id.email_et);
        passEt =  findViewById(R.id.password_et);

        usersRg =  findViewById(R.id.user_rg);

        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        signInBtn = findViewById(R.id.sign_in_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailEt.setVisibility(View.VISIBLE);
                passEt.setVisibility(View.VISIBLE);
                usersRg.setVisibility(View.VISIBLE);
                signInBtn.setVisibility(View.VISIBLE);

                registerBtn.setVisibility(View.GONE);
                loginBtn.setVisibility(View.GONE);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(i);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    emailId = emailEt.getText().toString();
                    password = passEt.getText().toString();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
