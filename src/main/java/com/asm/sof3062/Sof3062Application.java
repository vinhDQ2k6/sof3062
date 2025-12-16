package com.asm.sof3062;

import com.asm.sof3062.util.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>Sof3062Application</h1>
 * <p>
 * This is the main entrance of our application, like the front door of a house.
 * </p>
 * <p>
 * <b>Why do we need this?</b><br>
 * Every Spring Boot application needs a place to start. This class tells Spring
 * to wake up, look around for configurations, and start the web server.
 * </p>
 * <p>
 * We also tell it to ignore "DataSourceAutoConfiguration" because we are using
 * Firebase (a NoSQL database) instead of a traditional SQL database like MySQL.
 * If we didn't say this, Spring would get confused looking for a database URL.
 * </p>
 */
@SpringBootApplication
public class Sof3062Application {

	/**
	 * The main method that starts the whole show.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		// First, let's load our secret settings from the .env file
		EnvLoader.load();
		// Then, start the Spring application
		SpringApplication.run(Sof3062Application.class, args);
	}

	/**
	 * Creates a RestTemplate tool for the application to use.
	 * <p>
	 * Imagine RestTemplate as a messenger who can travel to other websites (URLs)
	 * to fetch data or send messages. We create it here once so we can reuse it
	 * everywhere.
	 * </p>
	 *
	 * @return A new instance of RestTemplate.
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
