package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class danwei extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danwei);
        RadioGroup rg =(RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView km1=(TextView)findViewById(R.id.km1);
                TextView dm1=(TextView)findViewById(R.id.dm1);
                TextView m1=(TextView)findViewById(R.id.m1);
                TextView cm1=(TextView)findViewById(R.id.cm1);
                TextView mm1=(TextView)findViewById(R.id.mm1);
                EditText dwet = (EditText)findViewById(R.id.dw_et);
                RadioButton km = (RadioButton)findViewById(R.id.km);
                RadioButton m = (RadioButton)findViewById(R.id.m);
                RadioButton dm = (RadioButton)findViewById(R.id.dm);
                RadioButton cm = (RadioButton)findViewById(R.id.cm);
                RadioButton mm = (RadioButton)findViewById(R.id.mm);

                String s =dwet.getText().toString();
                if(R.id.km==i){
                    km1.setText(s+"km");
                    m1.setText(String.valueOf(Double.parseDouble(s)/1000)+"m");
                    dm1.setText(String.valueOf(Double.parseDouble(s)/10000)+"dm");
                    cm1.setText(String.valueOf(Double.parseDouble(s)/100000)+"cm");
                    mm1.setText(String.valueOf(Double.parseDouble(s)/1000000)+"mm");
                }
                if(R.id.m==i){
                    m1.setText(s+"m");
                    km1.setText(String.valueOf(Double.parseDouble(s)/1000)+"km");
                    dm1.setText(String.valueOf(Double.parseDouble(s)*10)+"dm");
                    cm1.setText(String.valueOf(Double.parseDouble(s)*100)+"cm");
                    mm1.setText(String.valueOf(Double.parseDouble(s)*1000)+"mm");
                }
                if(R.id.dm==i){
                    dm1.setText(s+"dm");
                    km1.setText(String.valueOf(Double.parseDouble(s)/10000)+"km");
                    m1.setText(String.valueOf(Double.parseDouble(s)/10)+"m");
                    cm1.setText(String.valueOf(Double.parseDouble(s)*10)+"cm");
                    mm1.setText(String.valueOf(Double.parseDouble(s)*100)+"mm");
                }
                if(R.id.cm==i){
                    cm1.setText(s+"cm");
                    km1.setText(String.valueOf(Double.parseDouble(s)/100000)+"km");
                    dm1.setText(String.valueOf(Double.parseDouble(s)/10)+"dm");
                    m1.setText(String.valueOf(Double.parseDouble(s)/100)+"m");
                    mm1.setText(String.valueOf(Double.parseDouble(s)*10)+"mm");
                }
                if(R.id.mm==i){
                    mm1.setText(s+"mm");
                    km1.setText(String.valueOf(Double.parseDouble(s)/1000000)+"km");
                    m1.setText(String.valueOf(Double.parseDouble(s)/1000)+"m");
                    cm1.setText(String.valueOf(Double.parseDouble(s)/10)+"cm");
                    dm1.setText(String.valueOf(Double.parseDouble(s)/100)+"dm");
                }
            }
        });
    }
}
