/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

public class AsyncTaskGetMovies extends AsyncTask<String, Void, List<Movie>> {

	Activity activity;
	ProgressDialog dialog;
	Boolean flag = false;
	String item = null;

	@Override
	protected List<Movie> doInBackground(String... arg0) {
		try {
			BufferedReader in = null;
			HttpGet request = null;

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("page_limit", "20"));
			params.add(new BasicNameValuePair("country", "us"));
			params.add(new BasicNameValuePair("apikey",
					"eaxd282t3yntmw7z7qsn24sr"));
			List<Movie> movies;
			Log.d("Demo", arg0[0]);

			URI uri = null;
			Integer value = Integer.parseInt(arg0[0]);
			switch (value) {
			case 0:
				uri = URIUtils.createURI("http", "api.rottentomatoes.com", -1,
						"/api/public/v1.0/lists/movies/box_office.json",
						URLEncodedUtils.format(params, "UTF-8"), null);

				break;
			case 1:
				uri = URIUtils.createURI("http", "api.rottentomatoes.com", -1,
						"/api/public/v1.0/lists/movies/in_theaters.json",
						URLEncodedUtils.format(params, "UTF-8"), null);

				break;
			case 2:
				uri = URIUtils.createURI("http", "api.rottentomatoes.com", -1,
						"/api/public/v1.0/lists/movies/upcoming.json",
						URLEncodedUtils.format(params, "UTF-8"), null);

				break;
			case 3:
				uri = URIUtils.createURI("http", "api.rottentomatoes.com", -1,
						"/api/public/v1.0/lists/movies/opening.json",
						URLEncodedUtils.format(params, "UTF-8"), null);

				break;
			}
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
				movies = JSONParser.MoviesJSONParser.parseMovies(sb.toString());
				
				return movies;
			} else {
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	public AsyncTaskGetMovies(Activity activity) {
		dialog = new ProgressDialog(activity);
		this.activity = activity;
	}

	@Override
	protected void onPostExecute(List<Movie> result) {
		MoviesActivity activity1 = (MoviesActivity) activity;
		activity1.loadScreenData(result, item);
		dialog.dismiss();
	}

	@Override
	protected void onPreExecute() {
		dialog.setMessage("Loading movies");
		dialog.setCancelable(false);
		dialog.isIndeterminate();
		dialog.show();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
