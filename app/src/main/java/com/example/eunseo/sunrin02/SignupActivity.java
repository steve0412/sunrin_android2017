package com.example.eunseo.sunrin02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by eunseo on 2017-09-14.
 */

public class SignupActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText passwordCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        passwordCheck=(EditText)findViewById(R.id.passwordCheck);
    }

    public void onSignupClicked(View v){
        String username_str=username.getText().toString();
        String password_str=password.getText().toString();
        String passwordCheck_str=passwordCheck.getText().toString();

        if(password_str.equals(passwordCheck_str)){
            User user=new User(username_str,password_str);
            MainActivity.users[MainActivity.user_num]=user;
            MainActivity.user_num++;
            Intent resultIntent=new Intent();
            resultIntent.putExtra("USERNAME", username_str);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
        }

    }
}