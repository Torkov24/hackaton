package torkov.hristijan.hackatonstartertemplate.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing <strong>error codes and corresponding messages</strong> used in the application
 *
 * <p>Each enum constant encapsulates a unique error code and its descriptive message
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 1xxx - Client Errors: General errors due to invalid client actions
    REQUEST_PARAMS_VALIDATION_ERROR("TE-1000", "Validation failed for request parameters"),
    INVALID_STATUS_PARAM("TE-1001", "Invalid status"),
    MISSING_REQUEST_PARAM("TE-1002", "Missing request parameter"),

    // 2xxx - Authentication and Authorization Errors: Errors related to user authentication and
    // authorization
    MISSING_AUTH_HEADER("TE-2000", "Authorization header/schema not found"),
    UNABLE_TO_READ_TOKEN("TE-2001", "Unable to read token"),
    TOKEN_VALIDATION_FAILED("TE-2002", "Failed to validate JWT token"),
    TOKEN_EXPIRED("TE-2003", "Expired JWT token"),
    TOKEN_SIGNATURE_INVALID("TE-2004", "Signature validation failed for JWT token"),
    TOKEN_INVALID("TE-2005", "Invalid JWT token"),
    PUBLIC_KEYS_ERROR("TE-2006", "Error while retrieving public keys"),
    EMPTY_PRINCIPAL("TE-2007", "Empty principal found"),
    NO_PUBLIC_KEYS_AVAILABLE("TE-2008", "No public keys are available"),
    REQUIRED_CLAIMS_NOT_PRESENT("TE-2009", "Required claims aren't present in token"),
    ACCESS_DENIED("TE-2010", "Access is denied"),

    // 3xxx - Server Errors: Internal server errors and unexpected issues
    UNKNOWN_AUTH_ERROR("TE-3000", "Unknown authorization/filter error occurred"),
    UNKNOWN_RESOURCE_ERROR("TE-3001", "Unknown resource internal error"),
    INTERNAL_SERVER_ERROR("TE-3002", "Unknown internal server error"),

    // 4xxx - Resource Errors: Errors related to resources like users, products, etc., not being found
    // or not available
    RESOURCE_NOT_FOUND("TE-4000", "Resource not found"),
    RESOURCE_IN_USE("TE-4001", "Resource in use"),
    RESOURCE_EXISTS("TE-4002", "Resource exists"),
    RESOURCE_UPDATE_NOT_ALLOWED("TE-4003", "Resource update not allowed"),

    // 5xxx - Validation Errors: Errors related to input validation failures
    VALIDATION_ERROR("TE-5000", "Validation failed"),
    RESOURCE_INVALID_STATE("TE-5001", "Resource is in invalid state"),
    INVALID_REQUEST_PARAM_TYPE("TE-5002", "Invalid request parameter(s) type");

    private final String code;
    private final String message;
}


