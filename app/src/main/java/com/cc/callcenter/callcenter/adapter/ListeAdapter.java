package com.cc.callcenter.callcenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cc.callcenter.callcenter.R;
import com.cc.callcenter.callcenter.retrofit.KullaniciDto;

import java.util.List;

/**
 * Created by vektorel on 08.07.2018.
 */

public class ListeAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context context;
    private final List<KullaniciDto> values;

    public ListeAdapter(Context context, List<KullaniciDto> values) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.values = values;
        this.context = context;

    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public KullaniciDto getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.layout.list_view, null);

        TextView txUsername = (TextView) satirView.findViewById(R.id.lw_username);
        TextView txAdSoyad = (TextView) satirView.findViewById(R.id.lw_adSoyad);

        KullaniciDto k = values.get(position);
        txUsername.setText(k.getUsername());
        txAdSoyad.setText(k.getAd() + " " + k.getSoyad());

        return satirView;
    }


}