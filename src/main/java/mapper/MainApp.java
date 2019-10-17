/**
 * Стартовый класс
 */
package mapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class MainApp {
    static final Logger log = LogManager.getLogger(MainApp.class);
    public static void main(String[] args) {
        log.info("Start mapper");
        SpringApplication.run(MainApp.class, args);
    }
}
