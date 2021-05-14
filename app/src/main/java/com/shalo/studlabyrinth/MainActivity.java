package com.shalo.studlabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.shalo.studlabyrinth.MapsActivity;
import com.shalo.studlabyrinth.R;
import com.shalo.studlabyrinth.models.Route;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
    }

    public void onClickMaps(View view) {
        Route routeToSend = new Route(((Spinner) findViewById(R.id.MapName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.BeginningPointName)).getSelectedItem().toString(),
                                      ((Spinner) findViewById(R.id.endPointName)).getSelectedItem().toString());

        System.out.println(routeToSend);
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
}