package com.arizona.milkmoney;


import com.paypal.android.MEP.PayPal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class paypal extends Activity implements View.OnClickListener{

    
    ImageButton donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paypal);

        
        donate = (ImageButton) findViewById(R.id.donate);

        donate.setOnClickListener(this);

        
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.donate:
            	startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=anthony%40milkmoney1%2eorg&lc=EE&item_name=Mobile%20apps&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donate_SM%2egif%3aNonHosted")));
                break;
        }
    }
    
   
}

