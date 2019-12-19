package com.example.calculator;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class More extends AppCompatActivity {

    RadioButton log,sinh,tan,cosh,exp,tanh;
    TextView tv;
    EditText ed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
        RadioGroup rg =(RadioGroup)findViewById(R.id.rg2);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                log=(RadioButton)findViewById(R.id.log);
                sinh=(RadioButton)findViewById(R.id.sinh);
                tan=(RadioButton)findViewById(R.id.tan);
                cosh=(RadioButton)findViewById(R.id.cosh);
                exp=(RadioButton)findViewById(R.id.exp);
                tanh=(RadioButton)findViewById(R.id.tanh);
                tv=(TextView)findViewById(R.id.tv0);
                ed=(EditText)findViewById(R.id.ed1);

                String s =ed.getText().toString();
                if(R.id.log==checkedId){
                    tv.setText(String.valueOf(Math.log(Double.parseDouble(s))));
                }
                if(R.id.sinh==checkedId){
                    tv.setText(String.valueOf(Math.sinh(Double.parseDouble(s))));
                }
                if(R.id.tan==checkedId){
                    tv.setText(String.valueOf(Math.tan(Double.parseDouble(s))));
                }
                if(R.id.cosh==checkedId){
                    tv.setText(String.valueOf(Math.cosh(Double.parseDouble(s))));
                }
                if(R.id.exp==checkedId){
                    tv.setText(String.valueOf(Math.exp(Double.parseDouble(s))));
                }
                if(R.id.tanh==checkedId){
                    tv.setText(String.valueOf(Math.tanh(Double.parseDouble(s))));
                }
            }
        });
    }
}
