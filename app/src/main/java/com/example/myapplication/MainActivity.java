package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_converte = findViewById(R.id.btn_converte);
        final TextView edt_dollar = findViewById(R.id.edt_dollar);
        final TextView edt_real = findViewById(R.id.edt_real);
        final RadioGroup rb_grupo = findViewById(R.id.rb_grupo);
        final TextView txt_aviso = findViewById(R.id.txt_aviso);

        final DecimalFormat f = new DecimalFormat("#,##0.00");

        edt_dollar.setText(f.format(0.0));
        edt_real.setText(f.format(0.0));

        btn_converte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dollar = 0.0;
                double reais = 0.0;
                RadioButton radio_b;

                if (!edt_dollar.getText().toString().equals("")) {
                    dollar = Double.parseDouble(edt_dollar.getText().toString().replace(",","."));
                }
                if(!edt_real.getText().toString().equals("")){
                    reais = Double.parseDouble(edt_real.getText().toString().replace(",","."));
                }

                radio_b = findViewById(rb_grupo.getCheckedRadioButtonId());

                if(radio_b.getText().equals("Reais em Dollar")){

                        if(reais != 0.0) {
                            dollar = (reais * 2.1);
                            edt_dollar.setText(f.format(dollar));
                        }else{
                            txt_aviso.setText("Necessário Digitar o valor em Reais!");
                        }
                }else{
                        if(dollar != 0.0) {
                            reais = (dollar / 2.1);
                            edt_real.setText(f.format(reais));
                        }else{
                            txt_aviso.setText("Necessário Digitar o valor em Dollar!");
                        }
                }


            }
        });
    }
}
