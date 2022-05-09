package com.mytheresa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties property;
	
	/**
	 * This method is used to load the properties from the config.properties file
	 * @returns properties object
	 * @throws IOException
	 */
	public Properties init_property() throws IOException {
		
		property = new Properties();
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		property.load(ip);
		
		return property;
	}

}
