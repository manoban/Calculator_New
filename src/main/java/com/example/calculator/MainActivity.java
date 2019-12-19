package com.example.calculator;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;

import java.nio.DoubleBuffer;
import java.util.Map;

public class MainActivity extends AppCompatActivity   implements View.OnClickListener {

    Button b_0,b_1,b_2,b_3,b_4,b_5, b_6,b_7,b_8,b_9,
            b_del,b_add,b_sub,b_eq,b_dot,b_ac,b_div,b_mul,b_right,b_left,b_cos,b_sin;

    TextView tv_input;
    private StringBuilder builder = new StringBuilder();
    // public static final String TAG="RightFragment";

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.jzzh:
                intent.setClass(MainActivity.this,jzzh.class);
                startActivity(intent);
                break;
            case R.id.dwhs:
                intent.setClass(MainActivity.this,danwei.class);
                startActivity(intent);
                break;
            case R.id.tjhs:
                intent.setClass(MainActivity.this,Volume.class);
                startActivity(intent);
                break;
            case R.id.help:
                intent.setClass(MainActivity.this,help.class);
                startActivity(intent);
            case R.id.more:
                intent.setClass(MainActivity.this,More.class);
                startActivity(intent);
            default:

        }
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);//横屏

        setContentView(R.layout.activity_main);
        //实例化对象
        b_0= (Button)findViewById(R.id.zero);
        b_1= (Button)findViewById(R.id.one);
        b_2= (Button)findViewById(R.id.two);
        b_3= (Button)findViewById(R.id.three);
        b_4= (Button)findViewById(R.id.four);
        b_5= (Button)findViewById(R.id.five);
        b_6= (Button)findViewById(R.id.six);
        b_7= (Button)findViewById(R.id.seven);
        b_8= (Button)findViewById(R.id.eight);
        b_9= (Button)findViewById(R.id.nine);
        b_del= (Button)findViewById(R.id.del);
        b_eq= (Button)findViewById(R.id.eq);
        b_ac= (Button)findViewById(R.id.ac);
        b_dot= (Button)findViewById(R.id.dot);
        b_div= (Button)findViewById(R.id.div);
        b_mul= (Button)findViewById(R.id.mul);
        b_add= (Button)findViewById(R.id.add);
        b_sub= (Button)findViewById(R.id.sub);
        b_left= (Button)findViewById(R.id.left);
        b_right= (Button)findViewById(R.id.right);
        b_cos=(Button)findViewById(R.id.cos);
        b_sin=(Button)findViewById(R.id.sin);






        tv_input=(TextView)findViewById(R.id.tv);



        //设置点击事件


        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);
        b_add.setOnClickListener(this);
        b_sub.setOnClickListener(this);
        b_mul.setOnClickListener(this);
        b_div.setOnClickListener(this);
        b_ac.setOnClickListener(this);
        b_del.setOnClickListener(this);
        b_dot.setOnClickListener(this);
        b_eq.setOnClickListener(this);
        b_left.setOnClickListener(this);
        b_right.setOnClickListener(this);
        b_cos.setOnClickListener(this);
        b_sin.setOnClickListener(this);


    }
    private static final String TAG = "FragmentActivity";
    @Override
    public void onClick(View view) {
        String s = tv_input.getText().toString();//获取字符串的值
        int last = 0;
        if(builder.length()!=0)
        {
            last = builder.codePointAt(builder.length()-1);

        }
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
            case R.id.dot:

                tv_input.setText(s + ((Button) view).getText().toString());//输出字符串的值
                builder.append(((Button) view).getText().toString());

                Log.d(TAG, builder.toString());
                break;

            case R.id.ac:
                builder = builder.delete(0, builder.length());
                tv_input.setText(builder);
                break;

            case R.id.del:
                if (builder.length() != 0) {
                    builder = builder.delete(builder.length() - 1, builder.length());
                    tv_input.setText(builder);
                }
                break;

//string.contains()用于判断字符串string分是否包含子字符串“xxx”
            case R.id.add:
            case R.id.sub:
            case R.id.mul:
            case R.id.div:

                if (s.length() == 0) {
                    tv_input.setText("");
                } else
                    tv_input.setText(s + " " + ((Button) view).getText() + " ");
                builder.append(((Button) view).getText());
                break;
            case R.id.right:// )右括号
                if ((last >= '0' && last <= '9' || last == ')') && judge() == 1) {
                    builder = builder.append(")");
                    tv_input.setText(builder);
                }
                break;
            case R.id.left:// （左括号
                if ((last != '(') || (last <= '0' && last >= '9')) {
                    builder = builder.append("(");
                    tv_input.setText(builder);
                }
                break;


            case R.id.eq:
                if ((builder.length() > 1)) {
                    suanfa sf = new suanfa();
                    String jieguo;
                    try {
                        String equation = sf.toSuffix(builder);
                        // Log.d(TAG,equation.toString());
                        jieguo = sf.dealEquation(equation);

                    } catch (Exception ex) {
                        jieguo = "出错";
                    }
                    tv_input.setText(builder + "=" + jieguo);

                    builder = builder.delete(0, builder.length());
                    if (Character.isDigit(jieguo.charAt(0))) {
                        builder = builder.append(jieguo);
                    }
                }
                break;

            case R.id.sin: {


                tv_input.setText(String.valueOf(Math.sin(Double.parseDouble(s))));

                builder = builder.append("sin");


            }
            case R.id.cos: {


                tv_input.setText(String.valueOf(Math.cos(Double.parseDouble(s))));

                builder = builder.append("cos");


            }

        }
    }

    private int judge(){
        int a=0,b=0;
        for( int i = 0 ; i < builder.length() ;i++){
            if(builder.charAt(i)=='(' ) {
                a++;
            }
            if(builder.charAt(i)==')' ) {
                b++;
            }
        }
        if(a == b)
            return 0;
        if(a > b)
            return 1;
        return 2;
    }








}




