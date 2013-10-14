package com.autoeasy.base.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class CSVbase {
	public static String[] columns = {"action","makeFail","arguments"};
	
	public static List<CSVBean> getCSVBean(String csvFilename) throws FileNotFoundException{
		ColumnPositionMappingStrategy<CSVBean> strat = new ColumnPositionMappingStrategy<CSVBean>();
		strat.setType(CSVBean.class);
		strat.setColumnMapping(columns);
		CsvToBean<CSVBean> csv = new CsvToBean<CSVBean>();
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));	
		List<CSVBean> csvBeans = csv.parse(strat, csvReader);
		return csvBeans;
	}
}
