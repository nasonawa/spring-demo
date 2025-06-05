package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private final DeploymentMonitoringService monitoringService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		monitoringService.listDeployments();
	}

    @Autowired
    public DemoApplication(DeploymentMonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }
}
