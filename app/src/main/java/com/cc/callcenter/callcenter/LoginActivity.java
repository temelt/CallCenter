package com.cc.callcenter.callcenter;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cc.callcenter.callcenter.retrofit.KullaniciDto;
import com.cc.callcenter.callcenter.service.KullaniciService;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnCancel;
    Button btnRegister;
    EditText edtUsername;
    EditText edtPassword;
    KullaniciService kullaniciService = new KullaniciService();
    KullaniciDto kullaniciDto =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnCancel = (Button) findViewById(R.id.login_btn_iptal);
        btnLogin = (Button) findViewById(R.id.login_btn_login);
        btnRegister = (Button) findViewById(R.id.login_btn_register);
        edtPassword = (EditText) findViewById(R.id.login_edt_password);
        edtUsername = (EditText) findViewById(R.id.login_edt_username);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (edtUsername.getText().toString().equals("a") && edtPassword.getText().toString().equals("a")) {
                        /*KullaniciTask t=new KullaniciTask();
                        TaskParams[] taskParams =new TaskParams[1];
                        TaskParams p =new TaskParams();
                        p.setUsername(edtUsername.getText().toString());
                        p.setPass(edtPassword.getText().toString());
                        taskParams[0]=p;
                        kullaniciDto = t.execute(taskParams).get();

                        if (kullaniciDto != null) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("adSoyad",kullaniciDto.getAd() +" "+ kullaniciDto.getSoyad());
                            intent.putExtra("username",kullaniciDto.getUsername());
                            startActivity(intent);
                            LoginActivity.this.finish();
                        } else {
                            System.out.println("Kullanıcı Adı veya Şifre Hatalı");
                        }*/
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("adSoyad","Test Kullanıcı");
                        intent.putExtra("username","test");
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    class KullaniciTask extends AsyncTask<TaskParams, Void, KullaniciDto> {
        @Override
        protected KullaniciDto doInBackground(TaskParams... params) {
            TaskParams p = params[0];
            try {
                return kullaniciService.login(p.getUsername(), p.getPass());
            } catch (Exception e) {
                return null;
            }
        }
    }

    class TaskParams {
        private String username;
        private String pass;

        public String getPass() {
            return pass;
        }

        public String getUsername() {
            return username;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
