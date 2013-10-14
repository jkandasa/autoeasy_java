package com.autoeasy.base.testng;



import java.util.LinkedList;
import org.testng.TestNG;

import com.autoeasy.commonutils.Utils;


/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class AutoEasyTestNG {

	public static void runTestNG(String testNGxmlFilesLocation){
		LinkedList<String> suites = new LinkedList<String>();
		Utils.setFilesList(testNGxmlFilesLocation, suites, ".xml");
		TestNG testNG = new TestNG();
		testNG.setTestSuites(suites);
		testNG.run();
	}
}
