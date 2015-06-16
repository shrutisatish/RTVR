/*Shruti Satish
MidTerm*/

package com.example.midtermapp;

import java.io.IOException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class AsyncTaskGetThumbNailPhotos extends AsyncTask<String, Void, Bitmap> {
	ImageView imageView;
	String url;

	public AsyncTaskGetThumbNailPhotos(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected Bitmap doInBackground(String... arg0) {
		Bitmap image = null;
		url = arg0[0];
		try {
			Log.d("Demo", arg0[0]);
			URL url = new URL(arg0[0]);
			image = BitmapFactory.decodeStream(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		if (imageView.getTag().toString().equals(url))
			imageView.setImageBitmap(result);
	}
}