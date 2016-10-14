package com.ly.housepay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button house,creditLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        house=(Button)findViewById(R.id.house);
        creditLoan= (Button) findViewById(R.id.creditLoan);
        house.setOnClickListener(this);
        creditLoan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.house:
                startActivity(new Intent(MainActivity.this,HouseActivity.class));
                break;
            case R.id.creditLoan:
                startActivity(new Intent(MainActivity.this,CreditLoanActivity.class));
                break;
            default:
                break;
        }
    }
}
