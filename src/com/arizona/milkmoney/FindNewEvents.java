package com.arizona.milkmoney;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import info.androidhive.slidingmenu.EventsDetails;
import info.androidhive.slidingmenu.R;

public class FindNewEvents extends ListFragment implements OnItemClickListener {
	List<EventDetailPOJO> eD;
	   @Override
	   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	      View view = inflater.inflate(R.layout.list_fragment, container, false);
	      return view;
	   }
	   
	   @Override
	   public void onActivityCreated(Bundle savedInstanceState) {
	      super.onActivityCreated(savedInstanceState);
	      eD =new ArrayList<EventDetailPOJO>();
	      EventDetailPOJO pojo = new EventDetailPOJO();
	      pojo.setDate("December");
	      pojo.setDescription("This is so Good");
	      pojo.setEventId("256");
	      pojo.setProgramId("589");
	      pojo.setProgramName("Save Animals");
	      pojo.setTime("7:30");
	      pojo.setVolunteerCount(90);
	      pojo.setTotalVolunteerNeeded(100);
	      pojo.setAddress("Mill Avaenue");
	      pojo.setEventName("Daemm");
	      eD.add(pojo);
	      pojo = new EventDetailPOJO();
	      pojo.setDate("December");
	      pojo.setDescription("This is so Good");
	      pojo.setEventId("256");
	      pojo.setProgramId("589");
	      pojo.setProgramName("Save Humanity");
	      pojo.setTime("7:30");
	      pojo.setVolunteerCount(90);
	      pojo.setEventName("Daemm");
	      pojo.setTotalVolunteerNeeded(100);
	      pojo.setAddress("Mill Avaenue");
	      eD.add(pojo);
	      pojo = new EventDetailPOJO();
	      pojo.setDate("December");
	      pojo.setDescription("This is so Good");
	      pojo.setEventId("256");
	      pojo.setProgramId("589");
	      pojo.setProgramName("Hackathom");
	      pojo.setTime("7:30");
	      pojo.setVolunteerCount(90);
	      pojo.setEventName("Daemm");
	      pojo.setTotalVolunteerNeeded(100);
	      pojo.setAddress("Mill Avaenue");
	      eD.add(pojo);
	      
	      List <String>items = new ArrayList<String>();
	      for(EventDetailPOJO pojo1 : eD)
	      {
	    	  items.add(pojo1.getProgramName());
	      }
	      ArrayAdapter <String>adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
	      setListAdapter(adapter);
	      getListView().setOnItemClickListener(this);
	   }
	   
	   @Override
	   public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
	      Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
	      int i =0;
	      for(EventDetailPOJO pojo1 : eD)
	      {
	    	  if(i==position)
	    	  {
	    		  Intent i1 = new Intent(getActivity(), EventsDetails.class);
	    		  i1.putExtra("event",pojo1);
	    	      startActivity(i1);

	    	  }
	    	  i++;
	    	  }
	   }

}
