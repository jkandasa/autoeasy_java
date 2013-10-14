package com.autoeasy.base.testng;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.log4j.Logger;

import com.autoeasy.base.csv.CSVBean;
import com.autoeasy.base.csv.CSVbase;
import com.autoeasy.commonutils.LOGGER;
import com.autoeasy.commonutils.Utils;
import com.autoeasy.commonutils.collection.Results;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class CSVtestFile {
	final static Logger _logger = Logger.getLogger(LOGGER.CSV.toString());
	public boolean executeCSVfile(String csvFilename) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException, IOException{
		List<CSVBean> csvLines = CSVbase.getCSVBean(csvFilename);
		for(CSVBean csvBean: csvLines){
			_logger.info("CSV Bean: "+csvBean.toString());
			if(csvBean.getAction().startsWith("#")){
				_logger.debug("Skipping this line....");
			}else{
				Results.setLastRun(true);
				if(!executeCSVBean(csvBean)){
					if(csvBean.isMakeFail()){
						_logger.error("Failed on the line: "+csvBean.toString());
						return false;
					}
				}
			}			
		}
		return true;
	}
	public boolean executeCSVBean(CSVBean csvBean) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, IOException{
		String finalMethod = Utils.getFinalMethodName(csvBean.getAction());
		String className = Utils.getClassName(finalMethod);
		String methodName = Utils.getMethodName(finalMethod);
		Class<?> cls = Class.forName(className);
		Object object = cls.newInstance();
		cls.getDeclaredMethod(methodName, String.class).invoke(object, new Object[]{csvBean.getArguments()});
		return Results.isLastRun();
	}
}