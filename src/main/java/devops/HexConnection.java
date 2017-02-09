package devops;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;

public class HexConnection {
	private static final Logger logger = Logger.getLogger(HexConnection.class);

	public Connection getConnection() {
		Connection connection = null;
		logger.info("checkConnection() started");

		try {
			Properties prop = new Properties();
			
			
			/*File configDir = new File(System.getProperty("catalina.base"),"conf");
			File configFile = new File(configDir,"database_config.properties");
			InputStream stream = new FileInputStream(configFile);*/

			InputStream input = null;
			String filename = "database_config.properties";
			logger.info("prop.load started" + filename);
			prop.load(getClass().getClassLoader().getResourceAsStream(filename));
			//prop.load(stream);
			logger.info("prop.load ends");
			String connectionURL = prop.getProperty("connectionURL");

			String uname = prop.getProperty("uname");
			String psword = prop.getProperty("psword");
			String driver = prop.getProperty("driver");
			logger.info("Trying to get the driver");
			Class.forName(driver);
			logger.info("Registering driver Success..");
			// pw.println("Registering driver Success..");

			connection = DriverManager.getConnection(connectionURL, uname, psword);
		} catch (Exception e) {
			// pw.println("The error is==" + E.getMessage());
			logger.error(e);
		}
		return connection;
	}
}
