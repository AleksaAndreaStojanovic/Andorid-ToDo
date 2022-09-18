package com.metropolitan.cs330_pz_4244;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Izlistaj extends AppCompatActivity {

    TextView invNaslov;
    TextView invOpis;
    TextView invIzmeni;
    EditText invNaslov2;
    EditText invOpis2 ;
    Button invSacuvaj ;

    @Override
        public void onCreate( Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.izlistaj);

        invNaslov =  findViewById(R.id.txtInvisibleNaslov) ;
        invOpis =  findViewById(R.id.txtInvisibleOpis) ;
        invIzmeni =  findViewById(R.id.izmeniInvisible) ;
        invNaslov2 =  findViewById(R.id.invisibleNaslov) ;
        invOpis2 =  findViewById(R.id.invisibleOpis) ;
        invSacuvaj = findViewById(R.id.btnSacuvaj);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    @SuppressLint("Range")
    public void prikazi(View view) {
        TextView resultView= (TextView) findViewById(R.id.txtIzlistaj);
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.metropolitan.cs330_pz_4244.UserProvider/todo"), null, null, null, null);
        if(cursor.moveToFirst()) {
            StringBuilder strBuild=new StringBuilder();
            while (!cursor.isAfterLast()) {
                strBuild.append("\n").append(cursor.getString(cursor.getColumnIndex("id_todo"))).append(".\n Naslov: ").append(cursor.getString(cursor.getColumnIndex("naslov"))).append("\n Opis: ").append(cursor.getString(cursor.getColumnIndex("opis"))).append("\n Datum: ").append(cursor.getString(cursor.getColumnIndex("datum"))).append("\n Vreme: ").append(cursor.getString(cursor.getColumnIndex("vreme")));
                cursor.moveToNext();
            }
            resultView.setText(strBuild);
        }
        else {
            resultView.setText("No Records Found");
        }
    }

    public void obrisi(View view) {
        getContentResolver().delete(BeleskeProvider.CONTENT_URI,BeleskeProvider.idTodo + "='" + ((EditText) findViewById(R.id.txtObrisi)).getText().toString() + "'", null);

        Toast.makeText(this, "Zapis je obrisan iz baze", Toast.LENGTH_LONG).show();

        prikazi(view);

    }
    public void izmeni(View view) {

        ContentValues cv = new ContentValues();
        cv.put("naslov", ((EditText) findViewById(R.id.invisibleNaslov)).getText().toString());
        cv.put("opis", ((EditText) findViewById(R.id.invisibleOpis)).getText().toString());


        getContentResolver().update(BeleskeProvider.CONTENT_URI, cv, "id_todo = ?", new String[]{((EditText) findViewById(R.id.txtObrisi)).getText().toString()});

        Toast.makeText(this, "Zapis u bazi je izmenjen", Toast.LENGTH_LONG).show();
        invNaslov.setVisibility(View.INVISIBLE);
        invOpis.setVisibility(View.INVISIBLE);
        invIzmeni.setVisibility(View.INVISIBLE);
        invNaslov2.setVisibility(View.INVISIBLE);
        invOpis2.setVisibility(View.INVISIBLE);
        invSacuvaj.setVisibility(View.INVISIBLE);
        prikazi(view);

    }

    public void prikaziINV(View view){



        invNaslov.setVisibility(View.VISIBLE);
        invOpis.setVisibility(View.VISIBLE);
        invIzmeni.setVisibility(View.VISIBLE);
        invNaslov2.setVisibility(View.VISIBLE);
        invOpis2.setVisibility(View.VISIBLE);
        invSacuvaj.setVisibility(View.VISIBLE);


    }

}
