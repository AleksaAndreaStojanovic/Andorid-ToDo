package com.metropolitan.cs330_pz_4244;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragmentTransaction.replace(android.R.id.content, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return MenuChoice(item);
    }

    private void CreateMenu(Menu menu) {
        MenuItem navigacija = menu.add(0, 0, 0, "Navigacija");

        MenuItem mail = menu.add(0, 1, 1, "Mail");




    }
    private boolean MenuChoice(MenuItem item){

        switch (item.getItemId()) {
            case 0:
                Intent i1 = new Intent(this,Navigacija.class);
                startActivity(i1);
                return true;
            case 1:
                Intent i2 = new Intent(this,Mail.class);
                startActivity(i2);
                return true;

        }
        return false;
    }
}