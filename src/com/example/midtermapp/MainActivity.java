/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		List<String> moviesList = new ArrayList<String>();
		moviesList.add("Box Office Movies");
		moviesList.add("In Theaters Movies");
		moviesList.add("Opening Movies");
		moviesList.add("Upcoming Movies");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getBaseContext(), android.R.layout.simple_list_item_1,
				android.R.id.text1,moviesList);
		ListView moviesListView = (ListView) findViewById(R.id.listView1);
		moviesListView.setAdapter(adapter);
		moviesListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent0 = new Intent(getBaseContext(),
						MoviesActivity.class);
				intent0.putExtra("ListValue", arg2);
				startActivity(intent0);

			}
		});

	}
}
