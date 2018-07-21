package com.cc.callcenter.callcenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.cc.callcenter.callcenter.adapter.ListeAdapter;
import com.cc.callcenter.callcenter.database.DbHelper;
import com.cc.callcenter.callcenter.database.Kisi;
import com.cc.callcenter.callcenter.retrofit.KullaniciDto;

import java.util.List;

public class Veritabanictivity extends AppCompatActivity {

    DbHelper dbHelper ;
    ListView listView;
    Kisi seciliKisi;
    Button btnKisiEkle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veritabani);

        dbHelper = new DbHelper(this);
        btnKisiEkle = (Button) findViewById(R.id.btn_veritabani_ekle);

        btnKisiEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Veritabanictivity.this,KisiEkleActivity.class);
                startActivity(intent);
            }
        });

        listele();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = listView.getItemAtPosition(position);
                if(listItem instanceof Kisi){
                    seciliKisi = (Kisi) listItem;

                    AlertDialog alertDialog =new AlertDialog.Builder(Veritabanictivity.this)
                            .setTitle("Silme Onay ?")
                            .setMessage("Kaydı silmek istediğinizden emin misiniz.")
                            .setPositiveButton("Sil", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dbHelper.delete(seciliKisi);
                                    listele();
                                }
                            })
                            .setNegativeButton("İptal", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("HAYIR TIKLANDI");
                                }
                            })
                            .show();
                }
            }
        });
    }

    private void listele() {
        listView = (ListView) findViewById(R.id.veritabani_list);
        try {
            List<Kisi> data = dbHelper.getAll();
            ListeAdapter listeAdapter =new ListeAdapter(Veritabanictivity.this,data);
            listView.setAdapter(listeAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        listele();
    }

}
