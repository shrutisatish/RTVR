/*Shruti Satish
MidTerm*/

package com.example.midtermapp;


import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;

public class Movie implements Serializable {

	String smallUrl;
	String largeUrl;
	String id;
	String title;
	String mpaaRating;
	Integer duration;
	String date;

	String url;
	Bitmap image;
	String error;

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	Integer aScore;
	Integer cScore;
	
	Integer year;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Movie(JSONObject jSMovieObject) {
		try {
			this.mpaaRating = jSMovieObject.getString("mpaa_rating");

			this.title = jSMovieObject.getString("title");
			this.year = jSMovieObject.getInt("year");
			this.id = jSMovieObject.getString("id");
			
			JSONObject object = jSMovieObject.getJSONObject("posters");
			this.smallUrl = object.getString("thumbnail");
			this.largeUrl = object.getString("detailed");
			JSONObject ratingsObject = jSMovieObject.getJSONObject("ratings");
			
			

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Movie() {
	}

	public Movie(JSONObject jSMovieObject, String string) {
		try {

			String x = jSMovieObject.get("runtime").toString();
			if (x != null && !x.equals(""))
				this.duration = Integer.parseInt(x);

			JSONObject ratingsObject = jSMovieObject.getJSONObject("ratings");

			this.aScore = ratingsObject.getInt("audience_score");
			this.cScore = ratingsObject.getInt("critics_score");

			JSONObject datessObject = jSMovieObject
					.getJSONObject("release_dates");
			this.date = datessObject.getString("theater");
			JSONObject linksObject = jSMovieObject.getJSONObject("links");
			this.url = linksObject.getString("alternate");

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String getSmallUrl() {
		return smallUrl;
	}

	public void setSmallUrl(String smallUrl) {
		this.smallUrl = smallUrl;
	}

	public String getLargeUrl() {
		return largeUrl;
	}

	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getaScore() {
		return aScore;
	}

	public void setaScore(Integer aScore) {
		this.aScore = aScore;
	}

	public Integer getcScore() {
		return cScore;
	}

	public void setcScore(Integer cScore) {
		this.cScore = cScore;
	}

	@Override
	public String toString() {
		return "Movie [smallUrl=" + smallUrl + ", largeUrl=" + largeUrl
				+ ", id=" + id + ", title=" + title + ", mpaaRating="
				+ mpaaRating + ", duration=" + duration + ", date=" + date
				+ ", url=" + url + ", image=" + image + ", error=" + error
				+ ", aScore=" + aScore + ", cScore=" + cScore + ", year="
				+ year + "]";
	}

	

}
