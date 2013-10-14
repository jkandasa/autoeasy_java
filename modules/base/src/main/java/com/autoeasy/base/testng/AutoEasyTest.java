package com.autoeasy.base.testng;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoeasy.base.AutoEasyProperties;
import com.autoeasy.commonutils.LOGGER;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
@Test
public class AutoEasyTest {
	final static Logger _logger = Logger.getLogger(LOGGER.CSV.toString());
	
	@Test
	@Parameters(value="csv.file")
	public void csvTest(String csvFile){		
		try {
			Assert.assertTrue(new CSVtestFile().executeCSVfile(AutoEasyProperties.getFileLocation(csvFile)));
		} catch (Exception ex) {
			_logger.error("Throws Exception[CSV File Name: "+csvFile+"], ",ex);
			Assert.fail("Throws Exception[CSV File Name: "+csvFile+"]");
		}
	}
}
