package com.autoeasy.cli.csv;

import java.io.IOException;
import org.apache.log4j.Logger;
import com.trilead.ssh2.Connection;

import com.autoeasy.cli.Cli;
import com.autoeasy.cli.CliArgs;
import com.autoeasy.cli.CliConnections;
import com.autoeasy.cli.CmdStatus;
import com.autoeasy.commonutils.LOGGER;
import com.autoeasy.commonutils.Utils;
import com.autoeasy.commonutils.collection.ReferenceDB;
import com.autoeasy.commonutils.collection.Results;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 13, 2013
 */
public class CliMethods {
	final static Logger _logger = Logger.getLogger(LOGGER.CLI.toString());

	public static void createConnection(String csvArgs){
		CliArgs args = null;
		try{
			args = new CliArgs(Utils.getMapFromString(csvArgs));
			_logger.debug("Arguments: "+args.toString());
			Connection connection = CliConnections.getConnection(args.getHostname(), args.getPort());
			connection.connect();
			connection.authenticateWithPassword(args.getUser(), args.getPassword());		
			ReferenceDB.setCliConnection(args.getHostname(), connection);
		}catch(IOException ex){
			_logger.error("Error while making connection,", ex);
			Results.setLastRun(false);
		}
		
	}
	
	public static void executeCmd(String csvArgs){
		CliArgs args = null;
		try{
			args = new CliArgs(Utils.getMapFromString(csvArgs));
			_logger.debug("Arguments: "+args.toString());
			Connection connection = ReferenceDB.getCliConnection(args.getHostname());
			CmdStatus cmdStatus = Cli.execCmd(connection.openSession(), args.getCmd());
			_logger.debug(cmdStatus.toString());
			Results.setResult(cmdStatus.toString());
			if((args.getFailString() != null) && cmdStatus.getResult().contains(args.getFailString())){
				Results.setLastRun(false);
				_logger.warn("Fail String: Expected string found on the result!!");
			}else if((args.getPassString() != null) && !cmdStatus.getResult().contains(args.getPassString())){
				Results.setLastRun(false);
				_logger.warn("Pass String: Expected string not found on the result!!");
			}
		}catch(IOException ex){
			_logger.error("Error while executing cmd,", ex);
			Results.setLastRun(false);
		}
	}
	
}
