package com.example.secretscan;

import com.example.secretscan.config.SecureConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SecureConfigLoader configLoader = new SecureConfigLoader();

        String apiToken = configLoader.getRequiredOrInsecureDefault("APP_API_TOKEN");
        String dbPassword = configLoader.getRequiredOrInsecureDefault("APP_DB_PASSWORD");

        LOG.info("Application started with insecure secret fallback enabled.");
        LOG.info("API token (plaintext): {}", apiToken);
        LOG.info("DB password (plaintext): {}", dbPassword);
    }
}
