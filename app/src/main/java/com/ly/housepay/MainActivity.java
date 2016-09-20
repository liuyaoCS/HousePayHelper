package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText housePrice,houseEvaluation,charge;
    Button compute;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        housePrice= (EditText) findViewById(R.id.housePrice);
        houseEvaluation= (EditText) findViewById(R.id.evaluation);
        charge= (EditText) findViewById(R.id.charge);
        compute= (Button) findViewById(R.id.compute);
        result= (TextView) findViewById(R.id.ret);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hp=Double.parseDouble(housePrice.getText().toString());
                double he=Double.parseDouble(houseEvaluation.getText().toString());
                double ch=Double.parseDouble(charge.getText().toString());

                double dy=4.9*0.85/100;
                double dm=dy/12;
                double sum=hp*10000*he*0.7;
                int months=360;
                double downPay=hp*10000-sum+hp*10000*ch/100;
                double ret=sum*dm*Math.pow((1+dm), months);
                ret/=(Math.pow((1+dm), months)-1);
                double desiredIncome=ret*2;

                result.setText("首付金额->"+Math.ceil(downPay)+" 万\n"
                        +"贷款总额->"+Math.ceil(sum)+" 万\n"
                        +"每月还款->"+Math.ceil(ret)+" 万\n"
                        +"收入要求->"+Math.ceil(desiredIncome)+" 万");
            }
        });

    }
}
