package com.example.demo;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KubernetesConfig {
    private static final Logger logger = LoggerFactory.getLogger(KubernetesConfig.class);

    @Value("${openshift.url}")
    private String openshiftUrl;

    @Value("${openshift.token}")
    private String openshiftToken;

    @Value("${openshift.trustcerts:false}")
    private boolean trustCerts;

    @Bean
    @Qualifier("default")
    public OpenShiftClient openshiftClientConfig() {
        try {
            logger.info("Configuring OpenShift client with URL: {}, trustCerts: {}, token:{}", openshiftUrl, trustCerts,openshiftToken);
            OpenShiftClient client = new DefaultOpenShiftClient(getConfig());
            logger.info("OpenShift client created successfully");
            return client;
        } catch (Exception e) {
            logger.error("Failed to create OpenShift client", e);
            throw new RuntimeException("OpenShift client initialization failed", e);
        }
    }

    public Config getConfig() {
		Config config = new Config();
		config.setMasterUrl(openshiftUrl);
		config.setOauthToken(openshiftToken);
		config.setTrustCerts(trustCerts);
        config.setWebsocketPingInterval(300 * 1000L);
		return config;
	}
}