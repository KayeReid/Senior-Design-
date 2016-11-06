package com.example.kayla.buttonsafe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Kayla on 5/13/2016.
 */
public class TextMessageActivity extends SettingsActivity
{
    private EditText txtEditor;
    private EditText txtEditor2;
    private EditText txtEditor3;
    private EditText txtEditor4;
    private EditText txtEditor5;
    private EditText txtEditor6;
    private EditText txtEditor7;
    TextView textmsg = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

        txtEditor = (EditText) findViewById(R.id.fullname);
        txtEditor2 = (EditText) findViewById(R.id.phone_number);
        txtEditor3 = (EditText) findViewById(R.id.Going_to);
        txtEditor4 = (EditText) findViewById(R.id.Coming_from);
        txtEditor5 = (EditText) findViewById(R.id.age);
        txtEditor6 = (EditText) findViewById(R.id.physical_description);
        txtEditor7 = (EditText) findViewById(R.id.Medical_History);


        textmsg = (TextView) findViewById(R.id.demoMessage);
        textmsg.setText("Hi, this is " + txtEditor.getText().toString() + "! I am sending this text message using SafetyApp. Something has happened to me and I need help. Please call me at : "
                + txtEditor2.getText().toString() + " or take the information below to the authorities so they can help me.\n" + txtEditor3.getText().toString() + "\n" + txtEditor6.getText().toString()
                + "\n" + txtEditor4.getText().toString() + "\n" + txtEditor5.getText().toString() + "\n" + txtEditor7.getText().toString());

        final String text = (String) textmsg.getText();

        //sendSMS(AlertOptionsActivity.toPhoneNumber1, text);
        //sendSMS(AlertOptionsActivity.toPhoneNumber2, text);

    }
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
