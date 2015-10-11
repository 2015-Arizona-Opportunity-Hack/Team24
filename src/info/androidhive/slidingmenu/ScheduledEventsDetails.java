package info.androidhive.slidingmenu;

import com.arizona.milkmoney.EventDetailPOJO;
import com.arizona.milkmoney.GetUserCallback;
import com.arizona.milkmoney.Login;
import com.arizona.milkmoney.MainActivity;
import com.arizona.milkmoney.Register;
import com.arizona.milkmoney.ServerRequests;
import com.arizona.milkmoney.User;
import com.arizona.milkmoney.UserLocalStore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScheduledEventsDetails extends Activity implements View.OnClickListener{
	EventDetailPOJO ej;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_details);
		 ej = (EventDetailPOJO)getIntent().getSerializableExtra("event");
		TextView date = (TextView)findViewById(R.id.date);
		TextView address = (TextView)findViewById(R.id.eventAddress);
		TextView eventCategory = (TextView)findViewById(R.id.eventCategory);
		TextView eventName = (TextView)findViewById(R.id.eventName);
		Button rsvp = (Button)findViewById(R.id.rsvp);
		TextView volunteersAttending = (TextView)findViewById(R.id.volunteersAttending);
		TextView volunteersNeeded = (TextView)findViewById(R.id.volunteersNeeded);
		date.setText(ej.getDate());
		address.setText(ej.getAddress());
		eventCategory.setText(ej.getProgramName());
		eventName.setText(ej.getEventName());
		rsvp.setVisibility(View.GONE);
		volunteersAttending.setText(String.valueOf(ej.getVolunteerCount()));
		volunteersNeeded.setText(String.valueOf(ej.getTotalVolunteerNeeded()));
		
	}
	  @Override
	    public void onClick(View view) {
	        }

	private void storeData(User user,EventDetailPOJO ej) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.StoreEventDataAsyncTask(ej ,user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(ScheduledEventsDetails.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events_details, menu);
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
