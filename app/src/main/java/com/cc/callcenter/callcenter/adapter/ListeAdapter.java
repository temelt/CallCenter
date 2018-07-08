package com.cc.callcenter.callcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cc.callcenter.callcenter.R;
import com.cc.callcenter.callcenter.retrofit.KullaniciDto;

import java.util.List;

/**
 * Created by vektorel on 08.07.2018.
 */

public class ListeAdapter  extends ArrayAdapter<KullaniciDto> {
    private final Context context;
    private final List<KullaniciDto> values;

    public ListeAdapter(Context context,int res, List<KullaniciDto> values) {
        super(context,res);
        this.context = context;
        this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_view, parent, false);
        TextView txUsername = (TextView) rowView.findViewById(R.id.lw_username);
        TextView txAdSoyad = (TextView) rowView.findViewById(R.id.lw_adSoyad);

        KullaniciDto k = values.get(position);
        txUsername.setText(k.getUsername());
        txAdSoyad.setText(k.getAd() +" "+ k.getSoyad());

        return rowView;
    }



}