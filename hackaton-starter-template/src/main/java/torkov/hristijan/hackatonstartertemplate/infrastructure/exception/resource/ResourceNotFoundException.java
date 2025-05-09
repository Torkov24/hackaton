package torkov.hristijan.hackatonstartertemplate.infrastructure.exception.resource;

import torkov.hristijan.hackatonstartertemplate.infrastructure.exception.ErrorCode;

import java.util.EnumSet;

/** This exception represents the lack of resource (e. g by GUID) */
public class ResourceNotFoundException extends GeneralResourceException {
    public ResourceNotFoundException(String message, Throwable cause) {
        super(EnumSet.of(ErrorCode.RESOURCE_NOT_FOUND), message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(EnumSet.of(ErrorCode.RESOURCE_NOT_FOUND), message);
    }
}


