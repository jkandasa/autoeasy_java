package com.autoeasy.commonutils.collection;

import java.util.HashMap;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class MethodMapper {
	private static  HashMap<String, String> methodMapper;
	static{
		methodMapper = new HashMap<String, String>();		
		//CLI methods
		methodMapper.put("cli.create.connection", "com.autoeasy.cli.csv.CliMethods.createConnection");
		methodMapper.put("cli.execute.command", "com.autoeasy.cli.csv.CliMethods.executeCmd");
	}
	public static String get(String key){
		return methodMapper.get(key);
	}
}
