package com.example.topic1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etno;
    private TextView tvresult;
    private Button btnc,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0
            ,btnd,btnm,btns,btna,btndot,btnr;
    private double val1=Double.NaN;
    private double val2;
    private final char ADD='+',SUBTRACT='-',DIVISION='/',MULTIPLY='*',EQUALSTO='0';
    private char ACTION;
    private int counterdot=0,counteradd=0,countersubtract=0,countermultiply=0,counterdivide=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SettingViews();


        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterdot++;
                if(counterdot>1){}
                else {
                    etno.setText(etno.getText().toString() + ".");
                    val1=Double.parseDouble(etno.getText().toString());
                }
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etno.setText(etno.getText().toString()+"9");
            }
        });
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etno.getText().length()>0){
                    CharSequence name=etno.getText().toString();
                    etno.setText(name.subSequence(0,name.length()-1));
                    val1=Double.parseDouble(etno.getText().toString());
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    etno.setText(null);
                    tvresult.setText(null);
                }
            }
        });
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counteradd++;
                if(counteradd>1){}else {
                    Algorithm();
                    ACTION = ADD;
                    tvresult.setText(String.valueOf(val1) + "+");
                    etno.setText(null);
                }
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countermultiply++;
                if (countermultiply > 1) {
                }else {
                    Algorithm();
                    ACTION = MULTIPLY;
                    tvresult.setText(String.valueOf(val1) + "*");
                    etno.setText(null);
                }}
        });
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countersubtract++;
                if(countersubtract>1){}else {
                    Algorithm();
                    ACTION = SUBTRACT;
                    tvresult.setText(String.valueOf(val1) + "-");
                    etno.setText(null);
                }
            }
        });
        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterdivide++;
                if(counterdivide>1){}else {
                    Algorithm();
                    ACTION = DIVISION;
                    tvresult.setText(String.valueOf(val1) + "/");
                    etno.setText(null);
                }
            }
        });
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvresult.getText().length()>20){}else{
                counteradd = counterdivide = counterdot = countermultiply = countersubtract =0;
                Algorithm();
                ACTION = EQUALSTO;
                tvresult.setText(tvresult.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                CharSequence name = String.valueOf(val1);
                etno.setText(name.subSequence(0, name.length() - 2));
            }}
        });
    }
    private void SettingViews(){
        etno=findViewById(R.id.etno);
        tvresult=findViewById(R.id.tvresult);
        btnc=findViewById(R.id.btnc);
        btnd=findViewById(R.id.btnd);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);




        btnm=findViewById(R.id.btnm);
        btns=findViewById(R.id.btns);
        btna=findViewById(R.id.btna);
        btndot=findViewById(R.id.btndot);
        btnr=findViewById(R.id.btnr);
    }
    private void Algorithm(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(etno.getText().toString());
            switch(ACTION){
                case ADD:
                    val1=val1+val2;
                    break;
                case SUBTRACT:
                    val1=val1-val2;
                    break;
                case DIVISION:
                    val1=val1/val2;
                    break;
                case MULTIPLY:
                    val1=val1*val2;
                    break;
                case EQUALSTO:
                    break;
            }
        }
        else{
            val1=Double.parseDouble(etno.getText().toString());
        }
    }
}

