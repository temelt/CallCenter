package com.cc.callcenter.callcenter.actions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BtnRegisterClick extends AppCompatActivity implements View.OnClickListener {

    private AppCompatActivity from;
    private AppCompatActivity to;

    public BtnRegisterClick(AppCompatActivity from, AppCompatActivity to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(from, to.getClass());
        startActivity(intent);
        this.from.finish();
    }
}