/*Shruti Satish
MidTerm*/

package com.example.midtermapp;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {
	static public class MoviesJSONParser {
		static ArrayList<Movie> parseMovies(String jsonString)
				throws JSONException {
			Movie movie = null;
			ArrayList<Movie> movies = new ArrayList<Movie>();
			JSONObject response = new JSONObject(jsonString);
			JSONArray array = response.getJSONArray("movies");
			for (int i = 0; i < array.length(); i++) {
				JSONObject JSMovieObject = array.getJSONObject(i);
				movie = new Movie(JSMovieObject);

				movies.add(movie);

			}
			return movies;
		}

		static Movie parseMovie(String jsonString) throws JSONException {
			Log.d("Demo", "In Parser");
			Movie movie = null;
			ArrayList<Movie> movies = new ArrayList<Movie>();
			JSONObject response = new JSONObject(jsonString);

			movie = new Movie(response, "MovieActivity");
			return movie;
		}

		static Movie parseMovieForListView(String jsonString)
				throws JSONException {
			Log.d("Demo", "In Parser");
			Movie movie = null;
			ArrayList<Movie> movies = new ArrayList<Movie>();
			JSONObject response = new JSONObject(jsonString);

			movie = new Movie(response);
			return movie;
		}

	}

}
