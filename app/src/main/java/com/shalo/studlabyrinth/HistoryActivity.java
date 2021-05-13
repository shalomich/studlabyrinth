package com.shalo.studlabyrinth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historypage);
    }

    public void onClickMain(View view) {
        Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
        startActivity(intent);
    }

}