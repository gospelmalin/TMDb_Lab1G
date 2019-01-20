package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;


/**
 * The Class TMDBClient handles the communication with The Movie Database.
 */
public class TMDBClient {
	
	/** The client. */
	private Client client;
	
	/** The properties reader. */
	static PropertiesReader pr = new PropertiesReader();
	
	/** The api key. */
	private static String apiKey = pr.getApiKeyProperty();
	
	/** The start part of the URL used to Search for movies in TMDB. */
	private static String searchMoviesUrlStart = "https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&query=";
	
	/**
	 * Instantiates a new TMDB client.
	 */
	// constructor
	public TMDBClient() {
		client = ClientBuilder.newClient();
	}
	
	
	/**
	 * Query TMDB for movies.
	 *
	 * @param query the query
	 * @return the string
	 */
	public String queryTMDBForMovies(String query) {
		String URL = searchMoviesUrlStart + query;
		TMDBClient tc = new TMDBClient();
		GenericType<String> string = new GenericType<String>() {};
		String s = tc.client
				.target(URL)
				.request(MediaType.APPLICATION_JSON)
				.get(string); // get the JSON representation
		//print the JSON representation
		//System.out.println("This is the JSON string recieved: " + s); // Kept for reference only
		return s;
	}
}