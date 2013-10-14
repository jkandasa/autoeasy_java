package com.autoeasy.base.csv;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class CSVBean {
	private String action;
	private String arguments;
	private boolean makeFail= false;
	
	public String getAction() {
		return action;
	}
	public void setAction(String method) {
		this.action = method;
	}
	public String getArguments() {
		return arguments;
	}
	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	public boolean isMakeFail() {
		return makeFail;
	}
	public void setMakeFail(boolean makeFail) {
		this.makeFail = makeFail;
	}

	
	public String toString(){
		return new StringBuilder()
				.append("[Action: ").append(action).append("],")
				.append("[Make Fail: ").append(makeFail).append("],")
				.append("[Arguments: ").append(arguments).append("]")
				.toString();
	}
}
