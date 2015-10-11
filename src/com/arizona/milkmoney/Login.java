package com.arizona.milkmoney;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import info.androidhive.slidingmenu.R;
=======

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c

public class Login extends Activity implements View.OnClickListener {
    Button bLogin;
    TextView registerLink;
    EditText etUsername, etPassword;

    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        registerLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    @Override
<<<<<<< HEAD
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		bLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	String username = etUsername.getText().toString();
=======
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin:
                String username = etUsername.getText().toString();
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
                String password = etPassword.getText().toString();

                User user = new User(username, password);

                authenticate(user);
<<<<<<< HEAD
              
            }
          });
		registerLink.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
              
            }
          });
	}

	

=======
                break;
            case R.id.tvRegisterLink:
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
                break;
        }
    }
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c

    private void authenticate(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);
<<<<<<< HEAD
        Intent launchNextActivity;
        launchNextActivity = new Intent(this, MainActivity.class);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);                  
        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(launchNextActivity);
    }
    private Boolean exit = false;
    @Override
        public void onBackPressed() {
            if (exit) {
                finish(); // finish activity
            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);

            }

        }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
=======
        startActivity(new Intent(this, MainActivity.class));
    }
>>>>>>> 268d4b0bc35999f8ebacf749c94c360a93d0696c
}
