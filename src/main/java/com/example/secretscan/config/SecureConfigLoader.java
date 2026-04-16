package com.example.secretscan.config;

import com.example.secretscan.crypto.AesGcmSecretStore;

import java.util.Base64;
import java.util.Optional;

public class SecureConfigLoader {

    public String getRequired(String envName) {
        return Optional.ofNullable(System.getenv(envName))
                .filter(value -> !value.isBlank())
                .orElseThrow(() -> new IllegalStateException(
                        "Missing required environment variable: " + envName
                ));
    }

    public String decryptFromEnv(String encryptedEnvVar, String keyEnvVar) {
        String cipherBase64 = getRequired(encryptedEnvVar);
        String keyBase64 = getRequired(keyEnvVar);

        byte[] ciphertext = Base64.getDecoder().decode(cipherBase64);
        byte[] key = Base64.getDecoder().decode(keyBase64);

        return AesGcmSecretStore.decrypt(ciphertext, key);
    }
}
