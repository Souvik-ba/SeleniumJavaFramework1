package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import tests.TestGoogleSearchPage;

public class PropertiesFile_demo {
	public static Properties prop= new Properties();
	public static String config_path= "C:/Users/USER/workspace/maven-demo/src/test/java/config/config.properties";
	public static void main(String[] args) {
		try {
			getProperties();
			setProperties();
		} catch (IOException exp) {
			System.out.println("Error Message is : "+exp.getMessage());
			System.out.println("Cause of Error is: "+exp.getCause());
			exp.printStackTrace();
		}
		
	}
	
	public static void getProperties() throws IOException{
		
		InputStream input = new FileInputStream(config_path);
		prop.load(input);
		String browser_name=prop.getProperty("browser");
		
//		TestGoogleSearchPage.browserName=prop.getProperty("browser");
		
		TestGoogleSearchPage.browserName=browser_name;
		System.out.println(browser_name);
		
	}
	
	public static void setProperties() throws IOException{
		OutputStream output= new FileOutputStream(config_path);
		prop.setProperty("Result", "Pass-> Browser has opened");
		prop.store(output, null);
	}
	}
			
			
		
	
		
	


