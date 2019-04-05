package com.example.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MsgTela extends AppCompatActivity {

    private MediaPlayer mp;
    private long miliseg = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_tela);

        final TextView txt_msg = findViewById(R.id.txt_msg);

        mp = MediaPlayer.create(this,R.raw.elevador);
        mp.seekTo(47000);

        CountDownTimer timer = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mp.start();
                miliseg = miliseg+1;
                if(miliseg == 10) {
                    txt_msg.setText("Ten Years Later.....");
                }
            }

            @Override
            public void onFinish() {
                mp.stop();

                finish();
            }
        }.start();



    }
}
