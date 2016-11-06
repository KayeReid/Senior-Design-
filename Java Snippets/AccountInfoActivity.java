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
public class AccountInfoActivity extends Activity {
    public final static String TEXTMESSAGE="textmessage.txt";
    public final static String FULLNAME="name.txt";
    public final static String EMAIL="email.txt";
    public final static String PASSWORD="password.txt";
    public final static String PHONENUMBER="phone.txt";
    public final static String EMERGENCY_CONTACT="emergcon1.txt";
    public final static String EMERGENCY_CONTACT2="emergcon2.txt";
    public final static String PIN="pin.txt";
    public final static String SECURITYQUESTION="question.txt";
    public final static String SECURITYANSWER="answer.txt";

    private EditText txtEditor;
    private EditText txtEditor2;
    private EditText txtEditor3;
    private EditText txtEditor4;
    private EditText txtEditor5;
    private EditText txtEditor6;
    private EditText txtEditor7;
    private EditText txtEditor8;
    private EditText txtEditor9;

    TextView textmsg;
    TextView fullname;
    TextView email;
    TextView password;
    TextView phone;
    TextView contact1;
    TextView contact2;
    TextView pinnum;
    TextView ques;
    TextView ans;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_info);
        txtEditor = (EditText) findViewById(R.id.fullname);
        txtEditor2 = (EditText) findViewById(R.id.email);
        txtEditor3 = (EditText) findViewById(R.id.password);
        txtEditor4 = (EditText) findViewById(R.id.phone_number);
        txtEditor5 = (EditText) findViewById(R.id.Emergency_Contact_1);
        txtEditor6 = (EditText) findViewById(R.id.Emergency_Contact_2);
        txtEditor7 = (EditText) findViewById(R.id.PIN);
        txtEditor8 = (EditText) findViewById(R.id.Security_Question);
        txtEditor9 = (EditText) findViewById(R.id.Security_Question_Answer);

        //Populates the saved text file into the full name field when opening the settings view.
        try {
            InputStream in = openFileInput(FULLNAME);
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
                txtEditor.setText(sb.toString());
            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

        try {
            InputStream in = openFileInput(EMAIL);
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
                txtEditor2.setText(sb.toString());
            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(PASSWORD);
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
            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(PHONENUMBER);
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
                txtEditor4.setText(sb.toString());

            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(EMERGENCY_CONTACT);
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
                txtEditor5.setText(sb.toString());


            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(EMERGENCY_CONTACT2);
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
                txtEditor6.setText(sb.toString());


            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(PIN);
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
                txtEditor7.setText(sb.toString());


            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(SECURITYQUESTION);
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
                txtEditor8.setText(sb.toString());
            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            InputStream in = openFileInput(SECURITYANSWER);
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
                txtEditor9.setText(sb.toString());

            }
        }
        catch (java.io.FileNotFoundException e) {
            //No info has been saved yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void onSave(View v) {

        if ((txtEditor.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Full name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor2.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor3.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor4.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Phone Number cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor5.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Emergency Contact cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor6.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Emergency Contact 2 cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor7.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "PIN Number cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor8.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Security Question cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if ((txtEditor9.getText().toString().trim().equals(""))) {
            Toast.makeText(getApplicationContext(), "Security Answer cannot be empty", Toast.LENGTH_SHORT).show();
        }
        //Saves the information into a text file.
        else {
            try {
                OutputStreamWriter out = new OutputStreamWriter(openFileOutput(FULLNAME, 0));
                out.write(fullname.getText().toString());
                out.close();
                OutputStreamWriter out2 = new OutputStreamWriter(openFileOutput(EMAIL, 0));
                out2.write(email.getText().toString());
                out2.close();
                OutputStreamWriter out3 = new OutputStreamWriter(openFileOutput(PASSWORD, 0));
                out3.write(password.getText().toString());
                out3.close();
                OutputStreamWriter out4 = new OutputStreamWriter(openFileOutput(PHONENUMBER, 0));
                out4.write(phone.getText().toString());
                out4.close();
                OutputStreamWriter out5 = new OutputStreamWriter(openFileOutput(EMERGENCY_CONTACT, 0));
                out5.write(contact1.getText().toString());
                out5.close();
                OutputStreamWriter out6 = new OutputStreamWriter(openFileOutput(EMERGENCY_CONTACT2, 0));
                out6.write(contact2.getText().toString());
                out6.close();
                OutputStreamWriter out7 = new OutputStreamWriter(openFileOutput(PIN, 0));
                out7.write(pinnum.getText().toString());
                out7.close();
                OutputStreamWriter out8 = new OutputStreamWriter(openFileOutput(SECURITYQUESTION, 0));
                out8.write(ques.getText().toString());
                out8.close();
                OutputStreamWriter out9 = new OutputStreamWriter(openFileOutput(SECURITYANSWER, 0));
                out9.write(ans.getText().toString());
                out9.close();
                Toast.makeText(this, "Your information has been saved.", Toast.LENGTH_LONG).show();
            } catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }
}
