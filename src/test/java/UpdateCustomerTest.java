
import static org.junit.Assert.assertEquals;
import devops.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class UpdateCustomerTest {
	private static final Logger logger = Logger.getLogger(DeleteCustomerTest.class);

	@Test
	public void TestUpdateCustomer() throws ServletException, IOException {
		UpdateCustomer updateCustomer = new UpdateCustomer();
		try {
			logger.info("TestUpdateCustomer() started");
			int result = updateCustomer.update("Saraa", "chrompet", "9600008084", "96008083", "JAVA", "MCA",1);
			assertEquals(1, result);
			logger.info("Executed TestUpdateCustomer() Successfully");
		} catch (AssertionFailedError ae) {
			logger.error("AssertionFailedError in TestUpdateCustomer: " + ae);
		} catch (Exception ex) {
			logger.error("Exception in TestUpdateCustomer: " + ex);
		}
	}
}
