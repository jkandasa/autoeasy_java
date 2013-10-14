package com.autoeasy.cli;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.autoeasy.commonutils.LOGGER;
import com.trilead.ssh2.Connection;
import com.trilead.ssh2.Session;


/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 * Oct 12, 2013
 */
public class CliConnections{
	final static Logger _logger = Logger.getLogger(LOGGER.CLI.toString());

	public static Connection getConnection(String hostname) {
		return new Connection(hostname);
	}

	public static Connection getConnection(String hostname, int port) {
		return new Connection(hostname, port);
	}

	public static Session openSession(Connection connection) throws IOException {
		return connection.openSession();
	}

	public static boolean authenticateWithNone(Connection connection, String user) throws IOException {
		return connection.authenticateWithNone(user);
	}
	
	public static boolean authenticateWithPassword(Connection connection, String user, String password) throws IOException {
		return connection.authenticateWithPassword(user, password);
	}

	public static boolean authenticateWithPublicKey(Connection connection, String user, char[] pemPrivateKey, String password) throws IOException {
		return connection.authenticateWithPublicKey(user, pemPrivateKey, password);
	}

	public static boolean authenticateWithPublicKey(Connection connection, String user, File pemFile, String password) throws IOException {
		return connection.authenticateWithPublicKey(user, pemFile, password);
	}
	
	
}
