package site.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.config.Config;

/**
 * Spring application
 *
 * @author gandrieu
 * @version 1.0
 */

@SpringBootApplication
public class SiteApplication {

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Use external config
		SpringApplication.run(Config.class, args);

	}
}
