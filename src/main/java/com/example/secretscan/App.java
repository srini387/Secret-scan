package com.example.secretscan;

import com.example.secretscan.config.SecureConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SecureConfigLoader configLoader = new SecureConfigLoader();

        String apiToken = configLoader.getRequired("APP_API_TOKEN");
        String dbPassword = configLoader.getRequired("APP_DB_PASSWORD");

        LOG.info("Application started with secure secret sources.");
        LOG.info("API token fingerprint: {}", fingerprint(apiToken));
        LOG.info("DB password fingerprint: {}", fingerprint(dbPassword));
    }

    private static String fingerprint(String value) {
        if (value == null || value.length() < 8) {
            return "invalid";
        }
        return value.substring(0, 4) + "..." + value.substring(value.length() - 4);
    }
}
