package com.cc.callcenter.callcenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cc.callcenter.callcenter.database.DbHelper;
import com.cc.callcenter.callcenter.database.Kisi;

public class KisiEkleActivity extends AppCompatActivity {

    DbHelper dbHelper;
    Button btnKisiKaydet;
    EditText editAd;
    EditText editSoyad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_ekle);

        dbHelper = new DbHelper(this);
        btnKisiKaydet = (Button) findViewById(R.id.btn_kisi_ekle_kaydet);

        editAd = (EditText) findViewById(R.id.edt_kisi_ekle_ad);
        editSoyad = (EditText) findViewById(R.id.edt_kisi_ekle_soyad);

        btnKisiKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kisi kisi=new Kisi();
                kisi.setAd(editAd.getText().toString());
                kisi.setSoyad(editSoyad.getText().toString());
                dbHelper.save(kisi);
                KisiEkleActivity.this.finish();
            }
        });
    }
}
