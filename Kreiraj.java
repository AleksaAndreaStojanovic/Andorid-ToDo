package com.metropolitan.cs330_pz_4244;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Kreiraj extends AppCompatActivity {

    private int y, m, d, h, min;
    EditText txtDatum, txtVreme;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.kreiraj);
        txtDatum = findViewById(R.id.txtDatum);
        txtVreme = findViewById(R.id.txtVreme);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
    public void dodaj(View view) {

        ContentValues values = new ContentValues();
        values.put(BeleskeProvider.naslov, ((EditText) findViewById(R.id.txtNaslov)).getText().toString());
        values.put(BeleskeProvider.opis, ((EditText) findViewById(R.id.txtOpis)).getText().toString());
        values.put(BeleskeProvider.datum, ((EditText) findViewById(R.id.txtDatum)).getText().toString());
        values.put(BeleskeProvider.vreme, ((EditText) findViewById(R.id.txtVreme)).getText().toString());

        getContentResolver().insert(BeleskeProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), "Zapis dodat u bazu!!", Toast.LENGTH_LONG).show();
    }

    public void datum(View view) {

        final Calendar c = Calendar.getInstance();
        y = c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH);
        d = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view1, year, monthOfYear, dayOfMonth) -> txtDatum.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), y, m, d);
        datePickerDialog.show();
    }

    public void vreme(View view) {

        final Calendar c = Calendar.getInstance();
        h = c.get(Calendar.HOUR_OF_DAY);
        min = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view1, hourOfDay, minute) -> txtVreme.setText(hourOfDay + ":" + minute), h, min, false);
        timePickerDialog.show();
    }

}
