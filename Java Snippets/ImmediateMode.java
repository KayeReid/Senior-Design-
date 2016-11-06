package com.example.kayla.buttonsafe;


import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kayla on 9/29/2015.
 * Immediate Mode
 */

public class ImmediateMode extends FragmentActivity //implements View.OnClickListener
{

    public static final String tag = "Main";
    public long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private CountDownTimer countDownTimer;
    private final long startTime = 15;
    private final long interval = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.immediate);
        startB = (Button) this.findViewById(R.id.start);
        //startB.setOnClickListener(this);
        countDownTimer = new PopUpTimer(30000, 1000);

    }



    public void ShowPopup(View v)
    {
        android.app.FragmentManager manager = getFragmentManager();
        ImmediatePopup popup = new ImmediatePopup();
        popup.show(manager, "immediate_popup" );
        countDownTimer.start();
    }



    public void onClick(View v)
    {
        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            startB.setText("Start");
        }
        else
        {

            countDownTimer.cancel();
            timerHasStarted = false;
            startB.setText("RESET");
        }
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


 //CountDownTimer class
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
                Intent i=new Intent(ImmediateMode.this, MainActivity.class);
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
