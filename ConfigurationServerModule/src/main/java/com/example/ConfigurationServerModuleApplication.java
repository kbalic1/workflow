package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerModuleApplication.class, args);
		System.out.println("${HOME}");
	}
}