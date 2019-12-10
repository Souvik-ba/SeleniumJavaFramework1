package Log4j.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class utilsLog4j {
	private static Logger logger = LogManager.getLogger(utilsLog4j.class);

	public static void main(String[] args) {
		logger.info("Hi this is Log4j Testing");
		logger.fatal("This is fatal message");
		logger.warn("This is a warning message");
		logger.error("Error-404");
		logger.trace("This is trace messages");
		
		System.out.println("Test Completed");

	}

}
