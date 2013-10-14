package com.autoeasy.commonutils.collection;

import java.util.HashMap;

import com.trilead.ssh2.Connection;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class ReferenceDB {
	private static HashMap<String, Object> mapGeneral;
	private static HashMap<String, Connection> mapCliConnection;
	private static HashMap<String, String> customMapper;
	
	public static synchronized void initReferenceDB() {
		if(mapGeneral==null){
			mapGeneral = new HashMap<String, Object>();
		}
		if(mapCliConnection==null){
			mapCliConnection = new HashMap<String, Connection>();
		}
		if(customMapper==null){
			customMapper = new HashMap<String, String>();
		}
	}

	public static synchronized Object getReferenceGeneral(String key){
		return mapGeneral.get(key);		
	}

	public static synchronized void setReferenceGeneral(String key, Object obj){
		mapGeneral.put(key, obj);		
	}
	
	public static synchronized Connection getCliConnection(String key){
		return mapCliConnection.get(key);		
	}

	public static synchronized void setCliConnection(String key, Connection conn){
		mapCliConnection.put(key, conn);		
	}

	public static synchronized String getCustomMapper(String key) {
		return customMapper.get(key);
	}

	public static synchronized void setCustomMapper(String key, String value) {
		ReferenceDB.customMapper.put(key, value);
	}

}
