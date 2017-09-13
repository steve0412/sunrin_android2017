package com.example.eunseo.sunrin02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static User []users=new User[100];
    static int user_num=0;

    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
    }

    void onLoginClicked(View v){
        String username_str=username.getText().toString();
        String password_str=password.getText().toString();
        for(int i=0; i<user_num; i++){
            if(users[i].id.equals(username_str)){
                if(users[i].password.equals(password_str)){
                    Intent intent=new Intent(MainActivity.this,LoginedActivity.class);
                    intent.putExtra("USER", username_str);
                    startActivity(intent);
                    finish();
                    return ;
                }
                Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
        }
    }

    void onSignupClicked(View v){
        Intent intent=new Intent(MainActivity.this,SignupActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1){
            String username_str=data.getStringExtra("USERNAME");
            username.setText(username_str);
        }
    }
}
