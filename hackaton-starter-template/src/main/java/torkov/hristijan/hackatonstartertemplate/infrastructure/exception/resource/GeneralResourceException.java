package torkov.hristijan.hackatonstartertemplate.infrastructure.exception.resource;

import lombok.Getter;
import torkov.hristijan.hackatonstartertemplate.infrastructure.exception.ErrorCode;

import java.util.EnumSet;
import java.util.List;

/** Parent exception class for all the resource related exceptions */
public abstract class GeneralResourceException extends RuntimeException {
    @Getter
    private final EnumSet<ErrorCode> errorCodes;

    @Getter
    private final List<String> messages;

    protected GeneralResourceException(EnumSet<ErrorCode> errorCodes, String message) {
        super(message);

        this.errorCodes = errorCodes;
        this.messages = List.of(message);
    }

    protected GeneralResourceException(EnumSet<ErrorCode> errorCodes, String message, Throwable cause) {
        super(message, cause);

        this.errorCodes = errorCodes;
        this.messages = List.of(message);
    }

    protected GeneralResourceException(EnumSet<ErrorCode> errorCodes, List<String> messages) {
        super(String.join(" ; ", messages));

        this.errorCodes = errorCodes;
        this.messages = messages;
    }
}


