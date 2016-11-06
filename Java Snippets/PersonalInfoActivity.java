package com.example.kayla.buttonsafe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Kayla on 5/13/2016.
 */
public class PersonalInfoActivity extends Activity {

    public final static String TEXTMESSAGE="textmessage.txt";
    private EditText txtEditor3;
    private EditText txtEditor4;
    private EditText txtEditor5;
    private EditText txtEditor6;
    private EditText txtEditor7;

    TextView textmsg;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        txtEditor3 = (EditText) findViewById(R.id.Going_to);
        txtEditor4 = (EditText) findViewById(R.id.Coming_from);
        txtEditor5 = (EditText) findViewById(R.id.age);
        txtEditor6 = (EditText) findViewById(R.id.physical_description);
        txtEditor7 = (EditText) findViewById(R.id.Medical_History);

        //Populates the saved text file into the full name field when opening the settings view.
        try {
            InputStream in = openFileInput(TEXTMESSAGE);
            if (in != null) {
                InputStreamReader tmp = new InputStreamReader(in);
                //Buffer reader reads all of the text file before entering it in
                BufferedReader reader = new BufferedReader(tmp);
                String s;
                StringBuilder sb = new StringBuilder();
                while ((s = reader.readLine()) != null) {
                    sb.append(s + " ");
                }
                in.close();
                txtEditor3.setText(sb.toString());
                txtEditor4.setText(sb.toString());
                txtEditor5.setText(sb.toString());
                txtEditor6.setText(sb.toString());
                txtEditor7.setText(sb.toString());
            }
        } catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void onSave(View v) {

        //Saves the information into a text file to repopulate.

            try {
                OutputStreamWriter out = new OutputStreamWriter(openFileOutput(TEXTMESSAGE, 0));
                out.write(textmsg.getText().toString());
                out.close();
                Toast.makeText(this, "Your information has been saved.", Toast.LENGTH_LONG).show();
            } catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }

    }
}

