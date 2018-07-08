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

import java.util.concurrent.ExecutionException;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    Button btnCancel;
    KullaniciDto kullaniciDto;

    EditText edtAd;
    EditText edtSoyad;
    EditText edtUsername;
    EditText edtPass;
    KullaniciService kullaniciService = new KullaniciService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.register_btn_register);
        btnCancel = (Button) findViewById(R.id.register_btn_cancel);

        edtPass = (EditText) findViewById(R.id.register_edt_pass);
        edtUsername = (EditText) findViewById(R.id.register_edt_username);
        edtAd = (EditText) findViewById(R.id.register_edt_ad);
        edtSoyad = (EditText) findViewById(R.id.register_edt_soyad);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
                if(kullaniciDto !=null){
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    RegisterActivity.this.finish();
                }
            }
        });
    }

    private void register() {
        try {
            KullaniciTask t = new KullaniciTask();
            TaskParams[] taskParams = new TaskParams[1];
            TaskParams p = new TaskParams();
            p.username = edtUsername.getText().toString();
            p.pass = edtPass.getText().toString();
            p.ad=edtAd.getText().toString();
            p.soyad=edtSoyad.getText().toString();
            taskParams[0] = p;
            kullaniciDto = t.execute(taskParams).get();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class KullaniciTask extends AsyncTask<TaskParams, Void, KullaniciDto> {
        @Override
        protected KullaniciDto doInBackground(TaskParams... params) {
            TaskParams p = params[0];
            try {
                KullaniciDto kullaniciDto =new KullaniciDto();
                kullaniciDto.setAd(p.ad);
                kullaniciDto.setSoyad(p.soyad);
                kullaniciDto.setPassword(p.pass);
                kullaniciDto.setUsername(p.username);

                return kullaniciService.register(kullaniciDto);
            } catch (Exception e) {
                return null;
            }
        }
    }

    class TaskParams {
        private String username;
        private String pass;
        private String ad;
        private String soyad;
    }
}
