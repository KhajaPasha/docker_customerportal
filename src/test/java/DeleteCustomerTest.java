import static org.junit.Assert.assertEquals;

import devops.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class DeleteCustomerTest {
	private static final Logger logger = Logger.getLogger(DeleteCustomerTest.class);

	//@Test
	public void TestDeleteCustomer() throws ServletException, IOException {
		DeleteCustomer deleteCustomer = new DeleteCustomer();
		try {
			logger.info("TestDeleteCustomer() started");
			int result = deleteCustomer.delete(2222);
			assertEquals(1, result);
			logger.info("Executed TestDeleteCustomer() Successfully");
		} catch (AssertionFailedError ae) {
			logger.error("AssertionFailedError in TestDeleteCustomer: " + ae);
		} catch (Exception ex) {
			logger.error("Exception in TestDeleteCustomer: " + ex);
		}
	}
}
