package com.configuration;

import java.io.IOException;

public class Configurationhelper {
	
	public static Configuration_propertyfile getInstance() throws IOException {
		Configuration_propertyfile file=new Configuration_propertyfile();
		return file;	
	}
	
	private Configurationhelper() {
		
	}
	
	

}
