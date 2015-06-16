/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class MoviesActivity extends Activity {
	List<Movie> result;
	MovieArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movies);
		Integer ListValue = getIntent().getExtras().getInt("ListValue");
		new AsyncTaskGetMovies(this).execute(ListValue.toString());
	}

	void loadScreenData(List<Movie> result1, final String item) {
		this.result = result1;
		ListView lv = (ListView) findViewById(R.id.listView1);
		adapter = new MovieArrayAdapter(getApplicationContext(),
				R.layout.movieslayout, result);
		// Set the ListView adapter
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Intent intent = new Intent(getApplicationContext(),
						MovieActivity.class);

				intent.putExtra("ResultSet", result.get(position));
				intent.putExtra("Position", position);
				intent.putExtra("Item", item);
				startActivity(intent);

			}
		});

	}
}
