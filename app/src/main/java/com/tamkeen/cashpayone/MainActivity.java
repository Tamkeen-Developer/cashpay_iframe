package com.tamkeen.cashpayone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.tamkeen.cashpay_sdk.CashPay;
import com.tamkeen.cashpay_sdk.OnReply;

public class MainActivity extends AppCompatActivity implements OnReply {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        String iframeURL="https://www.tamkeen.com.ye:5050/initpayment/test/d3d16756085f693f312e5032dba41865e68277beb7b51332e3b8b79ba2513a62f525d6d918e650fe3230ff15c211e90a4021f4d8c13bc1902bf1c3dddb98551d";
        CashPay pay=CashPay.getInstance(iframeURL,this);
        pay.show(getSupportFragmentManager(),"pay");

    }

    /**
     * payment done but need to check (important)
     * use orderID on your server to check order status.
     */
    @Override
    public void onNeedToCheck() {

    }

    @Override
    public void onCancel() {

    }
}