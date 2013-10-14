package com.autoeasy.commonutils.collection;

public class Results {
	private static boolean lastRun;
	private static String result;
	
	public static boolean isLastRun() {
		return lastRun;
	}
	public static void setLastRun(boolean lastRun) {
		Results.lastRun = lastRun;
	}
	public static String getResult() {
		return result;
	}
	public static void setResult(String result) {
		Results.result = result;
	}

}

