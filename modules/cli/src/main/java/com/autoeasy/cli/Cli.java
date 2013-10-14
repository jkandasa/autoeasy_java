package com.autoeasy.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.autoeasy.commonutils.LOGGER;
import com.trilead.ssh2.Session;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class Cli {
	final static Logger _logger = Logger.getLogger(LOGGER.CLI.toString());

	// convert InputStream to String
	private static String getString(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}

		} catch (IOException ex) {
			_logger.error("Exception on InputStream parsing,", ex);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
					_logger.warn(ex);
				}
			}
		}
		return sb.toString();
	}

	public static CmdStatus execCmd(Session session, String cmd){
		CmdStatus cmdStatus = new CmdStatus();
		cmdStatus.setCmd(cmd);
		try {
			session.execCommand(cmd);
			cmdStatus.setResult(getString(session.getStdout()));
			cmdStatus.setError(getString(session.getStderr()));
			cmdStatus.setExitSiganl(session.getExitSignal());
			cmdStatus.setExitStatus(session.getExitStatus());
		} catch (IOException ex) {
			_logger.error("exception on command execution,",ex);
			cmdStatus.setExitSiganl(ex.getMessage());
			cmdStatus.setExitStatus(-1);
		}	
		return cmdStatus;
	}
}
