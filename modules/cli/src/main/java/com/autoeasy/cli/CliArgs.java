package com.autoeasy.cli;

import java.util.HashMap;

import com.autoeasy.commonutils.ArgMapper;
import com.autoeasy.commonutils.collection.ReferenceDB;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 14, 2013
 */
public class CliArgs {
	private String hostname;
	private int port = 22;
	private String user;
	private String password;
	private String cmd;
	private String passString;
	private String failString;
	
	public CliArgs(HashMap<String, String> keyValue){
		//Set hostname
		if(keyValue.get(ArgMapper.hostname) != null){
			if(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.hostname)) != null){
				setHostname(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.hostname)));
			}else{
				setHostname(keyValue.get(ArgMapper.hostname));
			}
		}
		//Set Port Number
		if(keyValue.get(ArgMapper.port) != null){
			setPort(Integer.valueOf(keyValue.get(ArgMapper.port)));
		}		
		//Set User	
		if(keyValue.get(ArgMapper.user) != null){
			if(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.user)) != null){
				setUser(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.user)));
			}else{
				setUser(keyValue.get(ArgMapper.user));
			}
		}
		//Set password
		if(keyValue.get(ArgMapper.password) != null){
			if(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.password)) != null){
				setPassword(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.password)));
			}else{
				setPassword(keyValue.get(ArgMapper.password));
			}
		}
		//Set cmd
		if(keyValue.get(ArgMapper.cmd) != null){
			setCmd(keyValue.get(ArgMapper.cmd));
		}
		//Set Pass String
		if(keyValue.get(ArgMapper.passString) != null){
			if(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.passString)) != null){
				setPassString(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.passString)));
			}else{
				setPassString(keyValue.get(ArgMapper.passString));
			}
		}
		//Set Fail String
		if(keyValue.get(ArgMapper.failString) != null){
			if(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.failString)) != null){
				setFailString(ReferenceDB.getCustomMapper(keyValue.get(ArgMapper.failString)));
			}else{
				setFailString(keyValue.get(ArgMapper.failString));
			}
		}
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getPassString() {
		return passString;
	}

	public void setPassString(String passString) {
		this.passString = passString;
	}

	public String getFailString() {
		return failString;
	}

	public void setFailString(String failString) {
		this.failString = failString;
	}
	
	public String toString(){
		return new StringBuilder()
			.append("[Hostname: ").append(hostname).append("],")
			.append("[User: ").append(user).append("],")
			.append("[Password: ").append(password).append("],")
			.append("[Port: ").append(port).append("],")
			.append("[CMD: ").append(cmd).append("],")
			.append("[Pass String: ").append(passString).append("],")
			.append("[Fail String: ").append(failString).append("]")
			.toString();
	}
}
