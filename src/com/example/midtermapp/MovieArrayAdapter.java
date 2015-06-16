/*Shruti Satish
MidTerm*/

package com.example.midtermapp;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {
	private static final String tag = "CountryArrayAdapter";
	private static final String ASSETS_DIR = "images/";
	private Context context;
	private ImageView image;
	private TextView title;
	private TextView year;
	private TextView mpaaRating;

	private List<Movie> movies = new ArrayList<Movie>();

	public MovieArrayAdapter(Context context, int textViewResourceId,
			List<Movie> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.movies = objects;
	}

	public int getCount() {
		return this.movies.size();
	}

	public Movie getItem(int index) {
		return this.movies.get(index);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			// ROW INFLATION
			Log.d(tag, "Starting XML Row Inflation ... ");
			LayoutInflater inflater = (LayoutInflater) this.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.movieslayout, parent, false);
			Log.d(tag, "Successfully completed XML Row Inflation!");
		}

		Movie movie = getItem(position);

		image = (ImageView) row.findViewById(R.id.imageView1);
		image.setTag(movie.getSmallUrl());
		title = (TextView) row.findViewById(R.id.textView1);

		year = (TextView) row.findViewById(R.id.textView2);

		mpaaRating = (TextView) row.findViewById(R.id.textView3);

		title.setText(movies.get(position).getTitle());

		if (movies.get(position).getYear() != null)
			year.setText(movies.get(position).getYear().toString());
		if (movies.get(position).getMpaaRating() != null)
			mpaaRating.setText(movies.get(position).getMpaaRating());

		new AsyncTaskGetThumbNailPhotos(image).execute(movies.get(position)
				.getSmallUrl());
		return row;
	}

}
