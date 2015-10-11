package com.arizona.milkmoney;

<<<<<<< HEAD
import java.io.IOException;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import info.androidhive.slidingmenu.R;


public class Register extends Activity implements View.OnClickListener{
    EditText etFName, etLName, etUsername, etPassword,  phone;
    CheckBox donor,volunteer,email;
    int donor_id=0,volunteer_id =0,email_id=0;
    Button bRegister;
    GoogleCloudMessaging gcm;
    Toast t;
    String PROJECT_NUMBER = "965944238167";

    String regid="";
    
=======
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Register extends Activity implements View.OnClickListener{
    EditText etName, etAge, etUsername, etPassword;
    Button bRegister;

>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

<<<<<<< HEAD
        etFName = (EditText) findViewById(R.id.etFName);
        etLName = (EditText) findViewById(R.id.etLName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        phone = (EditText) findViewById(R.id.phone);
        volunteer = (CheckBox) findViewById(R.id.volunteer);
        donor = (CheckBox) findViewById(R.id.donor);
        email = (CheckBox) findViewById(R.id.email);
        

        bRegister = (Button) findViewById(R.id.bRegister);

    }

    
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		bRegister.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	String fname = etFName.getText().toString();
                String lname = etLName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
               // String emailuser = email.getText().toString();
                String phoneuser = phone.getText().toString();
                
                String don = String.valueOf(donor_id);
                String vol = String.valueOf(volunteer_id);
                String need_email =String.valueOf(email_id);
                User user = new User(fname, lname, username,password,need_email, phoneuser, don, vol );
                registerUser(user);
              
            }
          });
        
        donor.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                      //is chkIos checked?
              if (((CheckBox) v).isChecked()) {
                               donor_id=1;
              }
            }  
          });
        email.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                      //is chkIos checked?
              if (((CheckBox) v).isChecked()) {
            	  email_id=1;
              }
            }
          });
volunteer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                      //is chkIos checked?
              if (((CheckBox) v).isChecked()) {
            	  volunteer_id =1;
              }

            }
          });
	}



    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        getRegId();
        serverRequest.storeUserDataInBackground(user, regid ,new GetUserCallback() {
        
        
        	@Override
            public void done(User returnedUser) {
            	
            	//startActivity(new Intent(this, MainActivity2.class));
                Intent loginIntent = new Intent(Register.this, MainActivity.class);
               // resultsintent.putExtra("commo",Commodity);
=======
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                User user = new User(name, age, username, password);
                registerUser(user);
                break;
        }
    }

    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(Register.this, Login.class);
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
                startActivity(loginIntent);
            }
        });
    }
<<<<<<< HEAD
    public void getRegId(){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
               // Toast.makeText(getApplicationContext(),"in asych" , Toast.LENGTH_SHORT).show();

                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                    regid = gcm.register(PROJECT_NUMBER);
                    msg = "Device registered, registration ID=" + regid;
                    Log.i("GCM",  msg);

                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();

                }
                return msg;
            }

            @Override
            protected void onPostExecute(String msg) {
                //etRegId.setText(msg + "\n");
            }
        }.execute(null, null, null);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

=======
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
}
