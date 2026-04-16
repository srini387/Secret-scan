package fixtures.samplecode;

/**
 * INTENTIONAL BAD EXAMPLE FOR SECRET SCANNER TESTING.
 * Do not use this pattern in production code.
 */
public class HardcodedSecrets {

    private static final String SLACK_BOT_TOKEN = "slack_test_token__123456789012__987654321098__fixture_only";
    private static final String PRIVATE_KEY_SNIPPET = "-----BEGIN TEST PRIVATE KEY-----MIIEvAIBADANBgkqhkiG9w0BAQEF";
    private static final String BASIC_AUTH = "admin:admin123!";

    public String getSlackBotToken() {
        return SLACK_BOT_TOKEN;
    }

    public String getBasicAuthHeader() {
        return "Basic " + java.util.Base64.getEncoder().encodeToString(BASIC_AUTH.getBytes());
    }

    public String getPrivateKeySnippet() {
        return PRIVATE_KEY_SNIPPET;
    }
}
