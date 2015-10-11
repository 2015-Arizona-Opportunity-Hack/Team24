package com.arizona.milkmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import info.androidhive.slidingmenu.R;

public class Router extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_router);
		UserLocalStore userLocalStore = new UserLocalStore(this);
		if(userLocalStore.getLoggedInUser()== null)
			startActivity(new Intent(this, Login.class));
		else
			{
			Intent launchNextActivity;
	        launchNextActivity = new Intent(this, MainActivity.class);
	        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);                  
	        launchNextActivity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
	        startActivity(launchNextActivity);
			}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.router, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
