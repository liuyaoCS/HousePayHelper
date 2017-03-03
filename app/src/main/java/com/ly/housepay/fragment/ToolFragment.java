package com.ly.housepay.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ly.housepay.activity.CreditLoanActivity;
import com.ly.housepay.activity.HouseActivity;
import com.ly.housepay.R;


public class ToolFragment extends Fragment implements View.OnClickListener{
    private View mView;
    Button house,creditLoan;
    private  void initViews(View view){
        house=(Button)view.findViewById(R.id.house);
        creditLoan= (Button) view.findViewById(R.id.creditLoan);
        house.setOnClickListener(this);
        creditLoan.setOnClickListener(this);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.frg_tool, container, false);
            initViews(mView);
        }
        return mView;
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.house:
                startActivity(new Intent(getActivity(),HouseActivity.class));
                break;
            case R.id.creditLoan:
                startActivity(new Intent(getActivity(),CreditLoanActivity.class));
                break;
            default:
                break;
        }
    }
}