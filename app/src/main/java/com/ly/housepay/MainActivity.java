package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText housePrice,houseEvaluation,charge,taxcharge,others;
    Button compute;
    TextView result;

    EditText creditSum,creditRate,creditTime;
    Button creditCompute;
    TextView creditRet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHouseFee();
        initCreditLoan();
    }

    private void initCreditLoan() {
        creditSum= (EditText) findViewById(R.id.creditSum);
        creditRate= (EditText) findViewById(R.id.creditRate);
        creditTime= (EditText) findViewById(R.id.creditTime);
        creditCompute= (Button) findViewById(R.id.creditCompute);
        creditRet= (TextView) findViewById(R.id.creditRet);
        creditCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum=Double.parseDouble(creditSum.getText().toString());
                double rate=Double.parseDouble(creditRate.getText().toString());
                double time=Double.parseDouble(creditTime.getText().toString());

                double interest=sum*10000*rate/100*time;
                double monthPay=(sum*10000+interest)/(time*12);

                creditRet.setText("利息总额->"+Math.ceil(interest)+" 元\n"
                        +"每月还款->"+Math.ceil(monthPay)+" 元");
            }
        });
    }

    private void initHouseFee() {
        housePrice= (EditText) findViewById(R.id.housePrice);
        houseEvaluation= (EditText) findViewById(R.id.evaluation);
        charge= (EditText) findViewById(R.id.charge);
        taxcharge= (EditText) findViewById(R.id.taxcharge);
        others=(EditText) findViewById(R.id.other);

        compute= (Button) findViewById(R.id.compute);
        result= (TextView) findViewById(R.id.ret);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hp=Double.parseDouble(housePrice.getText().toString());
                double he=Double.parseDouble(houseEvaluation.getText().toString());
                double ch=Double.parseDouble(charge.getText().toString());
                double tch=Double.parseDouble(taxcharge.getText().toString());
                double other=Double.parseDouble(others.getText().toString());

                double dy=4.9*0.85/100;
                double dm=dy/12;
                double sum=hp*10000*he*0.65;
                int months=360;
                double downPay=hp*10000-sum+hp*10000*ch/100+hp*10000*he*tch/100+other*10000;
                double ret=sum*dm*Math.pow((1+dm), months);
                ret/=(Math.pow((1+dm), months)-1);
                double desiredIncome=ret*2;

                result.setText("首付金额->"+Math.ceil(downPay)+" 元\n"
                        +"贷款总额->"+Math.ceil(sum)+" 元\n"
                        +"每月还款->"+Math.ceil(ret)+" 元\n"
                        +"收入要求->"+Math.ceil(desiredIncome)+" 元");
            }
        });
    }
}
