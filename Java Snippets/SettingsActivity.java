package com.example.kayla.buttonsafe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * Created by Kayla on 2/19/2016.
 */
public class SettingsActivity extends Activity
{
    public final static String TEXTMESSAGE="textmessage.txt";
    public EditText txtEditor;
    private EditText txtEditor2;
    private EditText txtEditor3;
    private EditText txtEditor4;
    private EditText txtEditor5;
    private EditText txtEditor6;
    private EditText txtEditor7;

    TextView textmsg;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        txtEditor=(EditText)findViewById(R.id.fullname);
        txtEditor2=(EditText)findViewById(R.id.phone_number);
        txtEditor3=(EditText)findViewById(R.id.Going_to);
        txtEditor4=(EditText)findViewById(R.id.Coming_from);
        txtEditor5=(EditText)findViewById(R.id.age);
        txtEditor6=(EditText)findViewById(R.id.physical_description);
        txtEditor7=(EditText)findViewById(R.id.Medical_History);

        Button btn1 = (Button) findViewById(R.id.btnPersonalInfo);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicks", "You Clicked Personal Info.");
                Intent i = new Intent(SettingsActivity.this, PersonalInfoActivity.class);
                startActivity(i);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btnAccountInfo);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicks", "You Clicked Account Info.");
                Intent i=new Intent(SettingsActivity.this, AccountInfoActivity.class);
                startActivity(i);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btnAlertOpt);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicks", "You Clicked Alert Info.");
                Intent i=new Intent(SettingsActivity.this, AlertOptionsActivity.class);
                startActivity(i);
            }
        });

        Button btn4 = (Button) findViewById(R.id.btnTextOpt);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicks", "You Clicked Text Info.");
                Intent i=new Intent(SettingsActivity.this, TextMessageOptionsActivity.class);
                startActivity(i);
            }
        });

        Button btn5 = (Button) findViewById(R.id.btnDone);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("clicks", "You Clicked Done.");
                Intent i=new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });




        //Populates the saved text file into the full name field when opening the settings view.
        try
        {
            InputStream in = openFileInput(TEXTMESSAGE);
            if(in != null)
            {
                InputStreamReader tmp=new InputStreamReader(in);
                //Buffer reader reads all of the text file before entering it in
                BufferedReader reader=new BufferedReader(tmp);
                String s;
                StringBuilder sb=new StringBuilder();
                while((s=reader.readLine())!= null)
                {
                    sb.append(s+" ");
                }
                in.close();
                txtEditor.setText(sb.toString());
                txtEditor2.setText(sb.toString());
                txtEditor3.setText(sb.toString());
                txtEditor4.setText(sb.toString());
                txtEditor5.setText(sb.toString());
                txtEditor6.setText(sb.toString());
                txtEditor7.setText(sb.toString());
            }
        }
        catch (java.io.FileNotFoundException e)
        {
            //No info has been saved yet
        }
        catch (Throwable t)
        {
            Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }
        textmsg = (TextView)findViewById(R.id.demoMessage);
        //If only required fields are filled in:
        if ((txtEditor3.getText().toString().trim().equals(""))&&(txtEditor4.getText().toString().trim().equals(""))&&(txtEditor5.getText().toString().trim().equals(""))&&(txtEditor6.getText().toString().trim().equals("")))
        {
            textmsg.setText("Hi, this is "+ txtEditor.getText().toString()+"! I am sending this text message using SafetyApp. Something has happened to me and I need help. Please call me at : "
                    + txtEditor2.getText().toString());
        }
        //If other fields are filled in:
        else
        {
            textmsg.setText("Hi, this is "+ txtEditor.getText().toString()+"! I am sending this text message using SafetyApp. Something has happened to me and I need help. Please call me at : "
                    + txtEditor2.getText().toString() +" or take the information below to the authorities so they can help me.\n" + txtEditor3.getText().toString()+"\n" +  txtEditor6.getText().toString()
                    + "\n" + txtEditor4.getText().toString()+ "\n" + txtEditor5.getText().toString()+ "\n" + txtEditor7.getText().toString());
        }
    }

    /**public void onSave(View v) {
        if ((txtEditor.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Full name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor2.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Phone number cannot be empty", Toast.LENGTH_SHORT).show();
        }
        //Saves the information into a text file.
        else {
            try {
                OutputStreamWriter out = new OutputStreamWriter(openFileOutput(TEXTMESSAGE, 0));
                out.write(textmsg.getText().toString());
                out.close();
                Toast.makeText(this, "Your information has been saved.", Toast.LENGTH_LONG).show();
            } catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
    } */

}


