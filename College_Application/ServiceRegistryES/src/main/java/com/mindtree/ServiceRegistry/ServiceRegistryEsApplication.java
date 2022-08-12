package com.mindtree.ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryEsApplication.class, args);
	}

}
