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

public class AsyncTaskGetPhoto extends AsyncTask<String, Void, Bitmap> {

	ImageView imageView;

	public AsyncTaskGetPhoto(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected Bitmap doInBackground(String... arg0) {
		Bitmap image = null;
		try {
			Log.d("Demo", arg0[0]);
			URL url = new URL(arg0[0]);
			image = BitmapFactory.decodeStream(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return image;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		imageView.setImageBitmap(result);
	}
}
