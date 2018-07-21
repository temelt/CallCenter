package com.cc.callcenter.callcenter;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.cc.callcenter.callcenter.adapter.ListeAdapter;
import com.cc.callcenter.callcenter.retrofit.KullaniciDto;
import com.cc.callcenter.callcenter.service.KullaniciService;

import java.util.List;

public class ListeActivity extends AppCompatActivity {

    KullaniciService kullaniciService =new KullaniciService();

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        listView = (ListView) findViewById(R.id.liste_list);
        try {
            List<KullaniciDto> data = new KullaniciTask().execute().get();
            ListeAdapter listeAdapter =new ListeAdapter(ListeActivity.this,data);
            listView.setAdapter(listeAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    class KullaniciTask extends AsyncTask<Void, Void, List<KullaniciDto>> {
        @Override
        protected List<KullaniciDto> doInBackground(Void... params) {
            try {
                return kullaniciService.liste();
            } catch (Exception e) {
                return null;
            }
        }
    }
}
