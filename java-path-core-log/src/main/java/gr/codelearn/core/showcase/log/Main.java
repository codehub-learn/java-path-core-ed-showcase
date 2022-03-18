package gr.codelearn.core.showcase.log;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        logger.info("This is a sample log!");
        logger.info("This is a sample log input date {}",LocalDate.now());
        Exception ex = new RuntimeException("Oops error");
        logger.error("Something went wrong. Details: {}",ex.getMessage());
    }
}
