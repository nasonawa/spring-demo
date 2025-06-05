package com.example.demo;

import com.example.demo.DeploymentMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeploymentController {

    private final DeploymentMonitoringService monitoringService;

    @Autowired
    public DeploymentController(DeploymentMonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/deployments")
    public String listDeployments() {
        monitoringService.listDeployments();
        return "Deployments listed in console";
    }
}