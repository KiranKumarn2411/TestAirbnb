package airbnb.testResourceRead;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 public class PropertyReader {
Properties prop = new Properties();
InputStream input;

public String getProperty(String key) {
	try {

		input = new FileInputStream("D:\\Selenium\\Workspace\\AirbnbAutomation\\src\\com\\airbnb\\utility\\config.properties");

		// load a properties file
		prop.load(input);

		// get the property value and print it out
	

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return prop.getProperty(key);
	
}
}
