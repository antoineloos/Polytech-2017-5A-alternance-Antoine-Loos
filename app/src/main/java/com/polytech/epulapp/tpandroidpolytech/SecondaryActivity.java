package com.polytech.epulapp.tpandroidpolytech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_secondary);
        Log.d("onCreate","état durant lequel l'activity est créée");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_back:
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart","état ou l'application est redémarrer");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "état durant lequel l'application est en pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","état durant lequel l'application est reprise depuis l'état de pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop","état durant lequel une demande pour stoper l'appli est executée");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","evenement appelé avant que l'appli soit détruite");
    }
}
