package Facebook_Test.Test.Facebook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//this class has functions to read from data.properties
public class PropertyFile {

	public String getProperty(String key) throws IOException {
		Properties property = new Properties();
		  FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
		  property.load(input);
		  return property.getProperty(key);
		
	}
	
}
