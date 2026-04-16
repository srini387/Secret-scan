# Security Notes

This project intentionally includes fake secrets for scanner testing, while modeling secure handling in runtime code.

## Controlled Exposure Rules

- Intentionally exposed fake secrets are stored only under `src/test/resources/fixtures`.
- Runtime config in `src/main/resources` does not include plaintext credentials.
- Values that look sensitive are synthetic and non-functional.

## Secure Handling Pattern

- Read runtime secrets from environment variables.
- Prefer short-lived credentials over static tokens.
- If persistence is needed, store encrypted payloads and keep encryption keys outside source control.

## Suggested Scanner Validation

1. Run scanner against whole repository.
2. Confirm alerts are raised for fixture files.
3. Confirm no alerts in `src/main/java` and `src/main/resources` (except intentional test data if added later).
4. Add this repository to CI as a recurring scanner regression baseline.
