package com.autoeasy.commonutils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.autoeasy.commonutils.collection.MethodMapper;
import com.autoeasy.commonutils.collection.ReferenceDB;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class Utils {
	final static Logger _logger = Logger.getLogger(LOGGER.UTILS.toString());
	public static void setFilesList(String dir, LinkedList<String> list, String fileFilter){
		File xmlLocation = new File(dir);
		if(xmlLocation.isDirectory()){
			File[] files = xmlLocation.listFiles();
			for(File file: files){
				if(file.isFile()){
					if(file.getName().toLowerCase().endsWith(fileFilter.toLowerCase())){
						list.add(file.getAbsolutePath());	
					}					
				}else if(file.isDirectory()){
					setFilesList(file.getAbsolutePath(), list, fileFilter);
				}
			}
		}		
	}
	
	public static String getFinalMethodName(String methodName){
		if(ReferenceDB.getCustomMapper(methodName) != null){
			methodName = ReferenceDB.getCustomMapper(methodName);
		}
		return MethodMapper.get(methodName);
	}

	public static String getMethodName(String fullMethod){
		return  fullMethod.substring(fullMethod.lastIndexOf(".")+1);
	}
	
	public static String getClassName(String fullMethod){
		return  fullMethod.substring(0,fullMethod.lastIndexOf("."));
	}
	
	public static HashMap<String, String> getMapFromString(String csvString) throws IOException{
		HashMap<String, String> keyValueMap = new HashMap<String, String>();
		String[] keyValues = csvString.split("#|#");
		for(String keyValue: keyValues){
			String key = null;
			String value = null;
			try{
				key = keyValue.substring(0, keyValue.indexOf('=')).trim();
				value = keyValue.substring(keyValue.indexOf('=')+1).trim();
				if(value.length() == 0){
					value = null;
				}
			}catch(Exception ex){
				//Ignore Exception
			}
			keyValueMap.put(key,value);
		}
		return keyValueMap;
	}
	
	public static String loadArguments(String line){
		Matcher m = Pattern.compile("@(\\w+)@").matcher(line);
	    StringBuffer sb = new StringBuffer();
		while(m.find()) {
			if(ReferenceDB.getCustomMapper(m.group(1)) != null){
				 m.appendReplacement(sb, ReferenceDB.getCustomMapper(m.group(1)));
			}else{
				_logger.warn("Not match found for: "+m.group(0));
			}
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
}
