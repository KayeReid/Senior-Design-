package com.example.kayla.buttonsafe;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Time;
import java.util.Calendar;

public class TimedEventMode extends Activity{

    private TextView text2;
    private Button startB2;
    private CountDownTimer countDownTimer;
    private final long startTime = 15;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static TimedEventMode inst;
    private TextView alarmTextView;
    public long timeElapsed;
    private boolean timerHasStarted = false;

    public static TimedEventMode instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timed);
        //When start is clicked, send user to timed2.xml for timer, end early, and no back button;
        //pop ups will be needed for the end early button
        startB2 = (Button) this.findViewById(R.id.start2);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

     /**   text2 = (TextView) this.findViewById(R.id.timer2);
        timeElapsedView2 = (TextView) this.findViewById(R.id.timeElapsed2);
        countDownTimer2 = new TimedCountDownTimer(startTime2, interval2);
        text2.setText(text2.getText() + String.valueOf(startTime2)); */

    }

    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            Intent myIntent = new Intent(TimedEventMode.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(TimedEventMode.this, 0, myIntent, 0);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            countDownTimer = new PopUpTimer(30000, 1000);
        } else {
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
            Log.d("MyActivity", "Alarm Off");
        }
    }

    public void onClick(View v)
    {
        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            startB2.setText("Start");
        }
        else
        {

            countDownTimer.cancel();
            timerHasStarted = false;
            startB2.setText("RESET");
        }
    }
    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }




    public void ShowPopup(View v)
    {
        android.app.FragmentManager manager = getFragmentManager();
        ImmediatePopup popup = new ImmediatePopup();
        popup.show(manager, "immediate_popup" );
        countDownTimer.start();
    }

    // popup class added by Rolf
    public static class ImmediatePopup extends DialogFragment implements View.OnClickListener {
        Button  Enter;
        EditText input;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.immediatepopup, null);
            Enter = (Button) view.findViewById(R.id.Enter);
            input = (EditText) view.findViewById(R.id.editText);
            Enter.setOnClickListener(this);
            setCancelable(false);
            return view;

        }


        @Override
        public void onClick(View view) {


            Boolean done;
            done = false;
            while(done == false) {
                if (view.getId() == R.id.Cancel) {
                    dismiss();
                    Toast.makeText(getActivity(), "Cancel was pressed!", Toast.LENGTH_LONG).show();
                }
                if ((view.getId() == R.id.Enter)) {
                    if(input.getText().toString().equals(AccountInfoActivity.PIN) )
                    {
                        dismiss();
                        Toast.makeText(getActivity(), "Enter was pressed!", Toast.LENGTH_LONG).show();
                        done = true;
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Try Again!", Toast.LENGTH_LONG).show();
                    }
                }

            }

        }
    }

    public class PopUpTimer extends CountDownTimer
    {

        public PopUpTimer(long startTime, long interval)
        {super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            //Close popup and send message also go to home screen
            {
                sendSMS(AlertOptionsActivity.toPhoneNumber1, TextMessageActivity.TEXTMESSAGE);
                Intent i=new Intent(TimedEventMode.this, MainActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Time Expired!! Message sent!!", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onTick(long seconds)
        {
            timeElapsed = startTime - seconds ;
        }
    }
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }


}