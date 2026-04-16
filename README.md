# Secret Scan Lab (Java)

This repository is a **safe training project** for evaluating secret scanning tools in Java ecosystems.

## Goals

- Provide a realistic Maven project structure.
- Include intentionally embedded **fake** secrets in controlled locations.
- Demonstrate a secure baseline for production code (no hardcoded secrets in runtime paths).

## Project Layout

- `src/main/java`: secure application code.
- `src/main/resources`: non-sensitive runtime config.
- `src/test/resources/fixtures`: intentionally vulnerable files for scanner validation.
- `docs`: supporting security guidance.

## Important Safety Notes

- All embedded secrets are **synthetic test values**, not real credentials.
- Intentionally exposed secrets are limited to `src/test/resources/fixtures`.
- Runtime code loads secrets from environment variables and supports encrypted blobs.

## Quick Start

1. Build and test:
   - `mvn clean test`
2. Run app:
   - `mvn exec:java`
3. Run your secret scanner against this repo and verify it catches fixture secrets.

## What Should Be Detected

Secret scanners should flag patterns in:

- `src/test/resources/fixtures/leaky-config.properties`
- `src/test/resources/fixtures/.env.test`
- `src/test/resources/fixtures/sample-code/HardcodedSecrets.java`
- `src/test/resources/fixtures/sample-code/legacy-service.yaml`

## Secure Path Demonstration

Main app uses:

- `APP_DB_PASSWORD` and `APP_API_TOKEN` from environment variables.
- Optional encrypted secret decryption via `AesGcmSecretStore`.

See `docs/security-notes.md` for operational recommendations.
