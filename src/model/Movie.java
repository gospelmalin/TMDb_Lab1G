package model;

import java.util.ArrayList;

/**
 * The Class Movie.
 */
public class Movie {
	
	/** The id. */
	private int id;
	
	/** The adult. */
	private boolean adult; // added in preparation for further development
	
	/** The belongs to collection. */
	private Object belongsToCollection; // added in preparation for further development
	
	/** The original language. */
	private String originalLanguage; // added in preparation for further development
	
	/** The original title. */
	private String originalTitle; // added in preparation for further development
	
	/** The title. */
	private String title;
	
	/** The overview. */
	private String overview;
	
	/** The release date. */
	private String releaseDate; //TODO date?
	
	/** The popularity. */
	private double popularity;
	
	/** The vote count. */
	private int voteCount; // added in preparation for further development
	
	/** The vote average. */
	private double voteAverage; // added in preparation for further development
	
	/** The genres. */
	private ArrayList<Object> genres = new ArrayList<Object>(); //(object: id & name), added in preparation for further development
	
	/** The production companies. */
	private ArrayList<Object> productionCompanies = new ArrayList<Object>(); //(object id name originCountry), added in preparation for further development

	/**
	 * Instantiates a new movie.
	 *
	 * @param idIn the id in
	 * @param titleString the title string
	 * @param overviewString the overview string
	 * @param releaseDateString the release date string
	 * @param popularityString the popularity string
	 */
	public Movie(int idIn, String titleString, String overviewString, String releaseDateString, Double popularityString) {
		id = idIn;
		title = titleString;
		overview = overviewString;
		releaseDate = releaseDateString;
		popularity = popularityString;
	}
	
	/**
	 * Instantiates a new movie.
	 */
	public Movie() {}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Movie id: " + id + "\nTitle: " + title + "\nOverview: " + overview + "\nRelease date: " + releaseDate + "\nPopularity: " + popularity + "\n";
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the overview.
	 *
	 * @return the overview
	 */
	public String getOverview() {
		return overview;
	}

	/**
	 * Sets the overview.
	 *
	 * @param overview the overview to set
	 */
	public void setOverview(String overview) {
		this.overview = overview;
	}

	/**
	 * Gets the popularity.
	 *
	 * @return the popularity
	 */
	public double getPopularity() {
		return popularity;
	}

	/**
	 * Sets the popularity.
	 *
	 * @param popularity the popularity to set
	 */
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}
	
}
