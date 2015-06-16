/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class AsyncTaskGetMovie extends AsyncTask<String, Void, Movie> {
	Activity acvtivity;
	TextView textview;
	Movie movie;

	public AsyncTaskGetMovie(Activity acvtivity, Movie movie) {
		super();
		this.acvtivity = acvtivity;
		this.movie = movie;
	}

	@Override
	protected Movie doInBackground(String... arg0) {
		Bitmap image = null;
		Movie mainMovie = new Movie();
		try {
			Log.d("Demo", arg0[0]);
			URL url = new URL(arg0[0]);
			image = BitmapFactory.decodeStream(url.openStream());

			BufferedReader in = null;
			HttpGet request = null;

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("apikey",
					"eaxd282t3yntmw7z7qsn24sr"));
			URI uri = null;

			uri = URIUtils.createURI("http", "api.rottentomatoes.com", -1,
					"/api/public/v1.0/movies/" + movie.getId() + ".json",
					URLEncodedUtils.format(params, "UTF-8"), null);

			Log.d("Demo", uri.toString());
			request = new HttpGet(uri);

			HttpClient client = new DefaultHttpClient();

			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				Log.d("Demo", "Entering loop");
				in = new BufferedReader(new InputStreamReader(response
						.getEntity().getContent()));
				StringBuffer sb = new StringBuffer("");
				String line = "";
				while ((line = in.readLine()) != null) {
					sb.append(line + "\n");
				}
				in.close();
				// Log.d("Demo", sb.toString());
				mainMovie = JSONParser.MoviesJSONParser.parseMovie(sb
						.toString());
				mainMovie.setMpaaRating(movie.getMpaaRating());
				mainMovie.setTitle(movie.getTitle());
				mainMovie.setYear(movie.getYear());
				mainMovie.setId(movie.getId());
				mainMovie.setImage(image);
				return mainMovie;
			} else {
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Movie result) {
		MovieActivity activity1 = (MovieActivity) acvtivity;
		activity1.loadScreenData(result);
	}

	

}
