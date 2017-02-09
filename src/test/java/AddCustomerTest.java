import java.io.IOException;



import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.AssertionFailedError;

import static org.junit.Assert.*;
import java.sql.*;
import devops.*;

public class AddCustomerTest {
	private static final Logger logger = Logger.getLogger(DeleteCustomerTest.class);

	@Test
	public void TestAddCustomer() throws ServletException, IOException {
		AddCustomer addCustomer = new AddCustomer();
		try {
			logger.info("TestAddCustomer() started");
			int result = addCustomer.add("Sara", "US", "9600008084", "9600008083", "JAVA", "MCA");
			assertEquals(1, result);
			logger.info("Executed TestAddCustomer() Successfully");
		} catch (AssertionFailedError ae) {
			logger.error("AssertionFailedError in TestAddCustomer: " + ae);
		} catch (Exception ex) {
			logger.error("Exception in TestAddCustomer: " + ex);
		}

	}

	@Test
	public void TestCheckConnection() throws ServletException, IOException {
		HexConnection hexConnection = new HexConnection();
		try {
			logger.info("TestCheckConnection() started");
			Connection result = hexConnection.getConnection();
			assertNotNull(result);
			logger.info("Executed TestCheckConnection() Successfully");
		} catch (AssertionFailedError ae) {
			logger.error("AssertionFailedError in TestAddCustomer: " + ae);
		} catch (Exception ex) {
			logger.error("Exception in TestAddCustomer: " + ex);
		}

	}
}
