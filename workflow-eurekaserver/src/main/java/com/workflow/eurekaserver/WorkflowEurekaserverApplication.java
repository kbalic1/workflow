package com.workflow.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WorkflowEurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowEurekaserverApplication.class, args);
	}
}
