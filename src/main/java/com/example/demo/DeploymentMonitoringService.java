package com.example.demo;

import io.fabric8.openshift.client.OpenShiftClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeploymentMonitoringService {
    
    @Autowired
    private OpenShiftClient openShiftClient;

    /*@Autowired
    public DeploymentMonitoringService(OpenShiftClient openShiftClient) {
        this.openShiftClient = openShiftClient;
    }*/

    public void listDeployments() {
        // Example: List all deployments in the default namespace
        openShiftClient.deploymentConfigs()
                .inNamespace("java-app")
                .list()
                .getItems()
                .forEach(dc -> System.out.println("Deployment Config: " + dc.getMetadata().getName()));
    }

}