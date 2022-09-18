package com.metropolitan.cs330_pz_4244;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

public class Fragment1 extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);


        Preference izlistaj = findPreference("izlistaj");
        Preference kreiraj = findPreference("kreiraj");


        izlistaj.setOnPreferenceClickListener((preference) -> {
            Intent i1 = new Intent(getActivity(), Izlistaj.class);
            this.startActivity(i1);
            return true;
        });
        kreiraj.setOnPreferenceClickListener((preference) -> {
            Intent i2 = new Intent(getActivity(), Kreiraj.class);
            this.startActivity(i2);
            return true;
        });


    }
}