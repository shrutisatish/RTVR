/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MovieActivity extends Activity {

	Integer position;
	String item;

	Movie movie = null;

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie);
		ImageView detailedImage = (ImageView) findViewById(R.id.imageView1);
		this.position = (Integer) this.getIntent().getExtras().get("Position");
		this.item = (String) this.getIntent().getExtras().get("Item");
		movie = (Movie) this.getIntent().getSerializableExtra("ResultSet");

		new AsyncTaskGetMovie(this, movie).execute(movie.getLargeUrl(),
				movie.getId());
		new AsyncTaskGetPhoto(detailedImage).execute(movie.getLargeUrl());
	}

	Movie movieResult;

	public void loadScreenData(Movie movie) {
		this.movieResult = movie;
		listView = (ListView) findViewById(R.id.listView1);

		ImageView back = (ImageView) findViewById(R.id.imageView4);
		ImageView globe = (ImageView) findViewById(R.id.imageView6);
		final Activity activity = this;
		OnClickListener clickListener = new OnClickListener() {
			public void onClick(View v) {
				if (v.getId() == R.id.imageView4) {
					finish();
				} else if (v.getId() == R.id.imageView6) {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW,
							Uri.parse(movieResult.getUrl()));
					Log.d("Demo", Uri.parse(movieResult.getUrl()).toString());
					startActivity(browserIntent);
				}
			}
		};
		back.setOnClickListener(clickListener);

		globe.setOnClickListener(clickListener);

		TextView year = (TextView) findViewById(R.id.textView2);
		if (movie.getDate() != null) {
			year.setText(movie.getDate());
		}
		TextView title = (TextView) findViewById(R.id.textView1);
		if (movie.getTitle() != null) {
			title.setText(movie.getTitle());
		}

		TextView mpaaRating = (TextView) findViewById(R.id.textView3);
		if (movie.getMpaaRating() != null) {
			mpaaRating.setText(movie.getMpaaRating());
		}
		TextView duration = (TextView) findViewById(R.id.textView4);
		if (movie.getDuration() != null) {
			int min = movie.getDuration() % 60;
			int hours = movie.getDuration() / 60;
			duration.setText(hours + "hr" + min + " min");
		}
		TextView aRatingView = (TextView) findViewById(R.id.textView8);
		if (movie.getaScore() != null) {
			aRatingView.setText(movie.getaScore() + "%");
		}
		TextView cRatingView = (TextView) findViewById(R.id.textView9);
		if (movie.getcScore() != null) {
			cRatingView.setText(movie.getcScore() + "%");
		}


	}

	
	
}
