package com.cc.callcenter.callcenter;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    Button btnListe;
    Button btnVeritabani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = (Button) findViewById(R.id.main_btn_camera);
        btnListe = (Button) findViewById(R.id.main_btn_liste);
        btnVeritabani = (Button) findViewById(R.id.main_btn_veritabani);

        this.setTitle(getIntent().getStringExtra("adSoyad"));

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(intent);
            }
        });

        btnListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListeActivity.class);
                startActivity(intent);
            }
        });

        btnVeritabani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Veritabanictivity.class);
                startActivity(intent);
            }
        });
    }
}
