package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HouseActivity extends AppCompatActivity {
    EditText housePrice,houseEvaluation,evaluationPrice,bankInterest,years,charge,taxcharge,others;
    Button compute;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        initHouseFee();
    }
    private void initHouseFee() {
        housePrice= (EditText) findViewById(R.id.housePrice);
        houseEvaluation= (EditText) findViewById(R.id.evaluation);
        evaluationPrice= (EditText) findViewById(R.id.evaluationPrice);
        bankInterest= (EditText) findViewById(R.id.bankInterest);
        years= (EditText) findViewById(R.id.loanYears);
        charge= (EditText) findViewById(R.id.charge);
        taxcharge= (EditText) findViewById(R.id.taxcharge);
        others=(EditText) findViewById(R.id.other);

        compute= (Button) findViewById(R.id.compute);
        result= (TextView) findViewById(R.id.ret);
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double hp=Double.parseDouble(housePrice.getText().toString()); //房屋总价
                double he=Double.parseDouble(houseEvaluation.getText().toString());//房屋评估（成）
                double hep=Double.parseDouble(evaluationPrice.getText().toString());//房评价格（万）
                double bi=Double.parseDouble(bankInterest.getText().toString());//银行利率（点）
                double ch=Double.parseDouble(charge.getText().toString());//中介费点
                double tch=Double.parseDouble(taxcharge.getText().toString());//税费点
                double other=Double.parseDouble(others.getText().toString());//其他费用
                int loadyears=Integer.parseInt(years.getText().toString());

                double dy=bi/100;
                double dm=dy/12; //每月贷款利率
                if(hep==0){
                    hep=hp*10000*he;
                }else{
                    hep=hep*10000;
                }
                double sum=hep*0.65;//可贷款总额
                int months=loadyears*12;//可贷款时间
                double downPay=hp*10000-sum+hp*10000*ch/100+hep*tch/100+other*10000;//总首付
                double sellerGet=hp*10000-sum;
                double govGet=hep*tch/100;
                double agencyGet=hp*10000*ch/100;
                double ret=sum*dm*Math.pow((1+dm), months);
                ret/=(Math.pow((1+dm), months)-1); //每月还贷
                double desiredIncome=ret*2;    //收入证明

                result.setText("首付金额->"+Math.ceil(downPay)+" 元\n"
                        +"(中介:"+agencyGet+"元;契税:"+govGet+"元;业主:"+sellerGet+"元)\n\n"
                        +"贷款总额->"+Math.ceil(sum)+" 元\n"
                        +"每月还款->"+Math.ceil(ret)+" 元\n"
                        +"收入要求->"+Math.ceil(desiredIncome)+" 元");
            }
        });
    }
}
