package repository;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import client.TMDBClient;
import model.Movie;

/**
 * The Class JsonHandler handles the Json-data and uses the json data to create java objects.
 */
public class JsonHandler {
	
	/** The movies ArrayList. */
	private ArrayList<Movie> movies = new ArrayList<Movie>();
	
	/**
	 * Creates the movie array from json string brought from TMDB.
	 *
	 * @param query the query
	 * @return the array list
	 */
	public ArrayList<Movie> createMovieArrayFromJsonString(String query) {
		TMDBClient tc = new TMDBClient();
		String jsonString = tc.queryTMDBForMovies(query);
		JSONObject jsonObject = processJsonStringToJsonObject(jsonString);
		String arrayName = "results";
		JSONArray resultsArray = processJsonObjectToJsonArray(jsonObject, arrayName);
		return movies = processJSONArrayAndCreateMovieArray(resultsArray);	
	}
	
	/**
	 * Prints the movies.
	 */
	public void printMovies() {
		for (int i=0; i < movies.size(); i++) {
			System.out.println(movies.get(i));
		}	
	}

	/**
	 * Process json string to json object.
	 *
	 * @param s the s
	 * @return the JSON object
	 */
	private JSONObject processJsonStringToJsonObject(String s) {
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(s);
		} catch (JSONException e) {
			System.err.println("Oops! A JSONException occurred in processJsonStringToJsonObject : " + e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * Process json object to json array.
	 *
	 * @param jsonObject the json object
	 * @param arrayName the array name
	 * @return the JSON array
	 */
	private JSONArray processJsonObjectToJsonArray(JSONObject jsonObject, String arrayName) {
		JSONArray jsonArray = null;
		try {
			jsonArray = jsonObject.getJSONArray(arrayName);
		} catch (JSONException e) {
			System.err.println("Oops! A JSONException occurred in processJsonObjectToJsonArray " + e.getMessage());
		}

		return jsonArray;
	}
	
	/**
	 * Process JSON array and create movie array.
	 *
	 * @param jsonArray the json array
	 * @return the array list
	 */
	private ArrayList<Movie> processJSONArrayAndCreateMovieArray(JSONArray jsonArray) {
		try {
			//Loop through the array and read all properties for the Movie object to be created. Finally add it to the array list.
			for (int i = 0; i < jsonArray.length(); i++) { 
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int id = jsonObject.getInt("id");
				String title = jsonObject.getString("title");
				String overview = jsonObject.getString("overview");
				String releaseDate = jsonObject.getString("release_date");
				Double popularity = jsonObject.getDouble("popularity");
			//create Movie object
				Movie movie = new Movie(id, title, overview, releaseDate, popularity);
				//print movie
				//System.out.println(movie); // Used during development only
			//Add movie to movie array list
				movies.add(movie);
			}
		} catch (JSONException e) {
			System.err.println("Oops! A JSONException occurred in processJSONArrayAndCreateMovieArray: " + e.getMessage());
		  }
		
		return movies;
	}

	/**
	 * Gets the movies.
	 *
	 * @return the movies
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}

	/**
	 * Sets the movies.
	 *
	 * @param movies the movies to set
	 */
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
}
