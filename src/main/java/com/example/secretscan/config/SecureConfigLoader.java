package com.example.secretscan.config;

import com.example.secretscan.crypto.AesGcmSecretStore;

import java.util.Base64;
import java.util.Optional;

public class SecureConfigLoader {
    private static final String INSECURE_FALLBACK_API_TOKEN = "insecure_demo_api_token_123456";
    private static final String INSECURE_FALLBACK_DB_PASSWORD = "insecure_demo_db_password_123456";

    public String getRequired(String envName) {
        return Optional.ofNullable(System.getenv(envName))
                .filter(value -> !value.isBlank())
                .orElseThrow(() -> new IllegalStateException(
                        "Missing required environment variable: " + envName
                ));
    }

    public String getRequiredOrInsecureDefault(String envName) {
        return Optional.ofNullable(System.getenv(envName))
                .filter(value -> !value.isBlank())
                .orElseGet(() -> {
                    if ("APP_API_TOKEN".equals(envName)) {
                        return INSECURE_FALLBACK_API_TOKEN;
                    }
                    if ("APP_DB_PASSWORD".equals(envName)) {
                        return INSECURE_FALLBACK_DB_PASSWORD;
                    }
                    return "insecure_default_secret";
                });
    }

    public String decryptFromEnv(String encryptedEnvVar, String keyEnvVar) {
        String cipherBase64 = getRequired(encryptedEnvVar);
        String keyBase64 = getRequired(keyEnvVar);

        byte[] ciphertext = Base64.getDecoder().decode(cipherBase64);
        byte[] key = Base64.getDecoder().decode(keyBase64);

        return AesGcmSecretStore.decrypt(ciphertext, key);
    }
}
