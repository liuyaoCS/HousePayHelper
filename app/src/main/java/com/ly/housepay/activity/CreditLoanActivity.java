package com.ly.housepay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ly.housepay.R;

public class CreditLoanActivity extends AppCompatActivity {
    EditText creditSum,creditRate,creditTime;
    Button creditCompute;
    TextView creditRet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_loan);
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
}
