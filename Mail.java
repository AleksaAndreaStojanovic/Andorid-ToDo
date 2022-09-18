package com.metropolitan.cs330_pz_4244;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Mail extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);
    }
    public void onClickEmail(View v) {
        EditText et = (EditText)findViewById(R.id.txtMail);
        EditText et1 = (EditText)findViewById(R.id.txtTo);
        String[] to =
                {et1.getText().toString()};
        String[] cc = {};
        sendEmail(to, cc, "Pozdrav!!!", et.getText().toString());
    }
    //-slanje e-mail poruke na drugi uređaj”-
    private void sendEmail(String[] emailAddresses, String[] carbonCopies,
                           String subject, String message)
    {

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String[] to = emailAddresses;
        String[] cc = carbonCopies;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}
