package com.autoeasy.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class AutoEasyProperties {
	public static final String LOG4J_PROPERTY_FILE = "autoeasy.log4j.properties.file";
	public static final String LOG4J_LOG_FILE = "autoeasy.log4j.log.file";
	public static final String TESTNG_XML_FILES_LOCATION = "autoeasy.testng.xml.suite.location";
	public static final String CUSTOME_MAPPER_FILES_LOCATION = "autoeasy.custom.mapper.location";
	
	private static String AUTOEASY_HOME = null;
	
	private static String log4jPropertyFile;
	private static String log4jLogFile;
	private static String testNGxmlFilesLocation;
	private static String customMapperFilesLocation;

	public static void loadProperties(String propertiesFile) throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		properties.load(new FileReader(propertiesFile));

		setLog4jPropertyFile(properties.getProperty(LOG4J_PROPERTY_FILE).trim());
		setLog4jLogFile(properties.getProperty(LOG4J_LOG_FILE).trim());
		setTestNGxmlFilesLocation(properties.getProperty(TESTNG_XML_FILES_LOCATION).trim());
		setCustomMapperFilesLocation(properties.getProperty(CUSTOME_MAPPER_FILES_LOCATION).trim());
	}
	
	
	public static String getHomeLocation(){
		if(AUTOEASY_HOME == null){
			AUTOEASY_HOME = new File(System.getProperty("user.dir")).getParent()+"/";
		}
		return AUTOEASY_HOME;		
	}

	public static String getFileLocation(String fileName){
		if(new File(fileName).exists()){
			return fileName;
		}else{
			return getHomeLocation()+fileName;
		}		
	}
	
	public static String getLog4jPropertyFile() {
		return log4jPropertyFile;
	}


	public static void setLog4jPropertyFile(String log4jPropertyFile) {
		AutoEasyProperties.log4jPropertyFile = getHomeLocation()+log4jPropertyFile;
		System.setProperty(LOG4J_PROPERTY_FILE, getLog4jPropertyFile());
	}


	public static String getLog4jLogFile() {
		return log4jLogFile;
	}


	public static void setLog4jLogFile(String log4jLogFile) {
		AutoEasyProperties.log4jLogFile = getHomeLocation()+log4jLogFile;
		System.setProperty(LOG4J_LOG_FILE, getLog4jLogFile());
	}


	public static String getTestNGxmlFilesLocation() {
		return testNGxmlFilesLocation;
	}


	public static void setTestNGxmlFilesLocation(String testNGxmlFilesLocation) {
		AutoEasyProperties.testNGxmlFilesLocation = getFileLocation(testNGxmlFilesLocation);
	}


	public static String getCustomMapperFilesLocation() {
		return customMapperFilesLocation;
	}


	public static void setCustomMapperFilesLocation(String customMapperFilesLocation) {
		AutoEasyProperties.customMapperFilesLocation = getFileLocation(customMapperFilesLocation);
	}
}
