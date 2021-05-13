package com.shalo.studlabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shalo.studlabyrinth.R;

public class CorpusMapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapspage);
    }

    public void onClickMain2(View view) {
        Intent intent = new Intent(CorpusMapsActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(CorpusMapsActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}