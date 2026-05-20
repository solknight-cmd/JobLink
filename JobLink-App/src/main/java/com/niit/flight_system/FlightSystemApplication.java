package com.niit.flight_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.niit.flightsystem", "com.niit.JobLink"})
public class FlightSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSystemApplication.class, args);
	}

}
