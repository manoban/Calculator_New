package com.example.calculator;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;




public class jzzh extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2,et3,et4;
    Button bt;
    String s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jzzh);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);
        bt = (Button)findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = et1.getText().toString();
                s2 = et2.getText().toString();
                s3 = et3.getText().toString();
                BOTH both = new BOTH();
                String jieguo;
                jieguo = both.transRadix(s1,Integer.parseInt(s2), Integer.parseInt(s3));
                et4.setText(jieguo);
                //Log.d(TAG,jieguo);
            }
        });
    }
    private static final String TAG = "FragmentActivity";
    @Override
    public void onClick(View view) {


    }
}

