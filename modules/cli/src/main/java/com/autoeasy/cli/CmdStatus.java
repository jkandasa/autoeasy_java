package com.autoeasy.cli;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class CmdStatus {
	private String cmd;
	private String result;
	private String error;
	private String exitSiganl;
	private Integer exitStatus;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getExitSiganl() {
		return exitSiganl;
	}
	public void setExitSiganl(String exitSiganl) {
		this.exitSiganl = exitSiganl;
	}
	public Integer getExitStatus() {
		return exitStatus;
	}
	public void setExitStatus(Integer exitStatus) {
		this.exitStatus = exitStatus;
	}
	
	public String toString(){
		return new StringBuilder()
		.append("[Command: ").append(cmd).append("],")
		.append("[Exit Signal: ").append(exitSiganl).append("],")
		.append("[Exit Status: ").append(exitStatus).append("],")
		.append("[Error: ").append(error).append("],")
		.append("[Output: ").append(result).append("]")
		.toString();
		
	}
	
}
