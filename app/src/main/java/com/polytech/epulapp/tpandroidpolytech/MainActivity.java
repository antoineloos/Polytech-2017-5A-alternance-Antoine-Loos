package com.polytech.epulapp.tpandroidpolytech;

import android.app.ActionBar;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener , SecondaryFragment.SecondaryFragmentListener {

    public Menu currentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate","état durant lequel l'activity est créée");
        if(savedInstanceState == null){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainFragment mf = new MainFragment();

        ft.replace(R.id.mainFrame, mf,"view1");
        ft.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        currentMenu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                //launchActivity();
                switchBetweenFragment();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void switchBetweenFragment()
    {


        MainFragment myFragment = (MainFragment)getFragmentManager().findFragmentByTag("view1");
        if (myFragment != null && myFragment.isVisible()) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            SecondaryFragment sf = new SecondaryFragment();

            ft.replace(R.id.mainFrame, sf , "view2");
            ft.addToBackStack("view2");
            ft.commit();
            currentMenu.findItem(R.id.action_settings).setTitle(getString(R.string.action_back));
        }
        else
            {
                SecondaryFragment secFragment = (SecondaryFragment)getFragmentManager().findFragmentByTag("view2");
                if (secFragment != null && secFragment.isVisible()) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    MainFragment sf = new MainFragment();

                    ft.replace(R.id.mainFrame, sf , "view1");
                    ft.addToBackStack("view1");
                    ft.commit();
                    currentMenu.findItem(R.id.action_settings).setTitle(getString(R.string.action_settings));
                }
            }

    }

    /*private void launchActivity() {

        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }*/ /*for switching between activity*/

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


    @Override
    public void onView2BtnClicked() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        SecondaryFragment sf = new SecondaryFragment();

        ft.replace(R.id.mainFrame, sf , "view2");
        ft.addToBackStack("view2");
        ft.commit();
        currentMenu.findItem(R.id.action_settings).setTitle(getString(R.string.action_back));
    }

    @Override
    public void onBackBtnClicked() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        MainFragment sf = new MainFragment();

        ft.replace(R.id.mainFrame, sf , "view1");
        ft.addToBackStack("view1");
        ft.commit();
        currentMenu.findItem(R.id.action_settings).setTitle(getString(R.string.action_settings));
    }
}
