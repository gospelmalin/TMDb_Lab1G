package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The Class PropertiesReader is used to read properties unique for each user.
 * Properties are read from a properties.properties file.
 */
public class PropertiesReader {
	
	/**
	 * Gets the api key property.
	 *
	 * @return the api key property
	 */
	public String getApiKeyProperty() {
		Properties prop = new Properties();
		InputStream input = null;
		String apiKey = null;

			try {
		
				input = new FileInputStream("properties.properties");
		
				// load a properties file
				prop.load(input);
		
				// get the property value for apiKey and print it out
				//System.out.println(prop.getProperty("apiKey"));
				
				// set property value to return variable
				apiKey = prop.getProperty("apiKey");
		
			} catch (IOException e) {
				System.err.println("An IOException occurred when reading properties. "+e.getMessage());
			}
			return apiKey;

		}
		
}

