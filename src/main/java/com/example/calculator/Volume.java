package com.example.calculator;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Volume extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume);
        RadioGroup rg =(RadioGroup)findViewById(R.id.rg1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                TextView m2=(TextView)findViewById(R.id.m2);
                TextView dm2 =(TextView)findViewById(R.id.dm2);
                TextView cm2=(TextView)findViewById(R.id.cm2);
                TextView mm2=(TextView)findViewById(R.id.mm2);

                EditText dwet1 = (EditText)findViewById(R.id.dwet);

                RadioButton m = (RadioButton)findViewById(R.id.lm);
                RadioButton cm = (RadioButton)findViewById(R.id.lcm);
                RadioButton dm = (RadioButton)findViewById(R.id.ldm);
                RadioButton mm = (RadioButton)findViewById(R.id.lmm);

                String s1 =dwet1.getText().toString();

                if(R.id.lm==i){
                    m2.setText(s1+"平方米");
                    dm2.setText(String.valueOf(Double.parseDouble(s1)*100)+"平方分米");
                    cm2.setText(String.valueOf(Double.parseDouble(s1)*10000)+"平方厘米");
                    mm2.setText(String.valueOf(Double.parseDouble(s1)*1000000)+"平方毫米");
                }
                if(R.id.lcm==i){
                    cm2.setText(s1+"平方厘米");
                    dm2.setText(String.valueOf(Double.parseDouble(s1)/100)+"平方分米");
                    m2.setText(String.valueOf(Double.parseDouble(s1)/10000)+"平方米");
                    mm2.setText(String.valueOf(Double.parseDouble(s1)*100)+"平方毫米");
                }
                if(R.id.ldm==i){
                    dm2.setText(s1+"平方分米");
                    m2.setText(String.valueOf(Double.parseDouble(s1)/100)+"平方米");
                    cm2.setText(String.valueOf(Double.parseDouble(s1)*100)+"平方厘米");
                    mm2.setText(String.valueOf(Double.parseDouble(s1)*10000)+"平方毫米");
                }
                if(R.id.lmm==i){
                    mm2.setText(s1+"平方毫米");
                    dm2.setText(String.valueOf(Double.parseDouble(s1)/10000)+"平方分米");
                    cm2.setText(String.valueOf(Double.parseDouble(s1)/100)+"平方厘米");
                    m2.setText(String.valueOf(Double.parseDouble(s1)/100000)+"平方米");
                }
            }
        });
    }
}
