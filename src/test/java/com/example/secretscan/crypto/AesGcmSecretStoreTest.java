package com.example.secretscan.crypto;

import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AesGcmSecretStoreTest {

    @Test
    void roundTripEncryptionAndDecryptionWorks() {
        byte[] key = Base64.getDecoder().decode("MDEyMzQ1Njc4OWFiY2RlZjAxMjM0NTY3ODlhYmNkZWY=");
        String secret = "fake-service-token-for-local-testing";

        byte[] cipher = AesGcmSecretStore.encrypt(secret, key);
        String plaintext = AesGcmSecretStore.decrypt(cipher, key);

        assertEquals(secret, plaintext);
    }
}
