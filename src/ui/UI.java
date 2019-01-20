package ui;

import static javax.swing.JOptionPane.*;

import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.ws.rs.ClientErrorException;

import model.Movie;
import repository.JsonHandler;

/**
 * The Class UI - the user interface.
 */
public class UI {
	//Working version without input control
	/**
	 * Run UI.
	 */
	public void runUI() {
		JFrame frame = new JFrame("User input dialog");
		while(true) {
			try {
				String message = null;
				String indata = showInputDialog(frame, "Välkommen till TMDb filmsök!"
						+ "\nAnge del av titeln för att söka: ", "TMDb Filmsök by Malin", JOptionPane.PLAIN_MESSAGE);
				if (indata == null) {
					System.out.println("indata: " + indata);
					break;
				}
				System.out.println("indata: "+indata);
				indata = indata.trim();
				System.out.println("trimmad indata: "+indata);
				indata = URLEncoder.encode(indata, "UTF-8");
				System.out.println("encoded indata: "+indata);
	
				// "Normal" path
				JsonHandler jH = new JsonHandler();
				ArrayList<Movie> movies = jH.createMovieArrayFromJsonString(indata); //1
				//2 alternative way of getting the movie data:
				//jH.createMovieArrayFromJsonString(indata); 
				//movies = jH.getMovies(); 
				message = showMovies(movies);
				showMessageDialog(frame, message, "Resultat", JOptionPane.PLAIN_MESSAGE);
			} catch (ClientErrorException e) {
				showMessageDialog(frame, "Felaktig inmatning. \nSkriv in text för att söka. \nClientErrorException: "+ e.getMessage(), "Felaktig input", JOptionPane.ERROR_MESSAGE);
				System.err.println("Felaktig inmatning. ClientErrorException: "+ e.getMessage());
			} catch (HeadlessException e1) {
				System.err.println("Oops! Du stötte på ett HeadlessException: "+ e1.getMessage());
			} catch (UnsupportedEncodingException e2) {
				System.err.println("Oops! Jag har misslyckats med att koda om din inmatning så att servern kan läsa den: "+ e2.getMessage());
			}
			
		}
		System.exit(0);
	}
	
	
	/**
	 * Show movies.
	 *
	 * @param movies the movies
	 * @return the string
	 */
	private String showMovies(ArrayList<Movie> movies) {
		String message = "";			
		for(int i=0; i<movies.size(); i++) {
			int id = movies.get(i).getId();
			String title = movies.get(i).getTitle();
			String overview = movies.get(i).getOverview();
			double popularity = movies.get(i).getPopularity();
			message = message + "\nMovie id: " + id + "\nTitle: " + title + "\nOverview: " + overview + "\nPopularity: " + popularity + "\n";
		}
		return message;
		
	}
	
}