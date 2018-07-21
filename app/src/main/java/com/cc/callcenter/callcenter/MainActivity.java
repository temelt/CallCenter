package com.cc.callcenter.callcenter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    Button btnListe;
    Button btnVeritabani;
    Button btnArama;
    Button btnSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = (Button) findViewById(R.id.main_btn_camera);
        btnListe = (Button) findViewById(R.id.main_btn_liste);
        btnVeritabani = (Button) findViewById(R.id.main_btn_veritabani);
        btnArama = (Button) findViewById(R.id.main_btn_call);
        btnSensor = (Button) findViewById(R.id.main_btn_sensor);

        this.setTitle(getIntent().getStringExtra("adSoyad"));

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        btnListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListeActivity.class);
                startActivity(intent);
            }
        });

        btnVeritabani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Veritabanictivity.class);
                startActivity(intent);
            }
        });

        btnArama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callForwardString = "905355353535";
                Intent intentCallForward = new Intent(Intent.ACTION_CALL);
                Uri uri2 = Uri.fromParts("tel", callForwardString, "#");
                intentCallForward.setData(uri2);
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intentCallForward);
            }
        });

        btnSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(intent);
            }
        });
    }
}
