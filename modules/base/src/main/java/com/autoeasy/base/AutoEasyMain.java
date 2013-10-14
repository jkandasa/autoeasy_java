package com.autoeasy.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.autoeasy.base.testng.AutoEasyTestNG;
import com.autoeasy.commonutils.Utils;
import com.autoeasy.commonutils.collection.ReferenceDB;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class AutoEasyMain {
	private static Logger _logger = Logger.getLogger(AutoEasyMain.class);
	private static String AUTOEASY_PROPERTIES_FILE = "conf/autoeasy.properties";

	//Logger Configuration
	public static void initializeLog4j(){
		PropertyConfigurator.configureAndWatch(System.getProperty(AutoEasyProperties.LOG4J_PROPERTY_FILE));
		_logger.debug("log4j Property File: "+System.getProperty(AutoEasyProperties.LOG4J_PROPERTY_FILE));
		_logger.debug("log4j Log File: "+System.getProperty(AutoEasyProperties.LOG4J_LOG_FILE));
	}

	public static void loadProperties() throws FileNotFoundException, IOException{
		AutoEasyProperties.loadProperties(AutoEasyProperties.getHomeLocation()+AUTOEASY_PROPERTIES_FILE);
	}
	
	public static void loadCustomMappers(String customMappersFileLocation) throws FileNotFoundException, IOException{
		LinkedList<String> files = new LinkedList<String>();
		Utils.setFilesList(customMappersFileLocation, files, ".properties");
		Properties properties = new Properties();
		for(String file : files){
			properties.load(new FileReader(file));
			Set<Object> keys = properties.keySet();
			for(Object key: keys){
				ReferenceDB.setCustomMapper(key.toString(), properties.get(key.toString()).toString().trim());
			}
		}		
	}

	public static void main(String[] args) throws IOException{
		loadProperties();
		initializeLog4j();
		ReferenceDB.initReferenceDB();
		loadCustomMappers(AutoEasyProperties.getCustomMapperFilesLocation());
		AutoEasyTestNG.runTestNG(AutoEasyProperties.getTestNGxmlFilesLocation());
	}
}
