//package torkov.hristijan.hackatonstartertemplate.infrastructure.exception;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import torkov.hristijan.hackatonstartertemplate.infrastructure.exception.resource.GeneralResourceException;
//
///**
// * Global exception handler
// */
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//
//    /**
//     * Handle resource related errors
//     */
//    @ExceptionHandler({
//            ResourceInUseException.class,
//            ResourceExistsException.class,
//            ResourceUpdateNotAllowedException.class,
//            ResourceInvalidStateException.class
//    })
//    public ResponseEntity<ErrorResponse> handleResourceException(
//            HttpServletRequest request, GeneralResourceException exception) {
//        log.error(
//                "{} Resource failed ; Request URI: {}", exception.getErrorCodes(), request.getRequestURI(), exception);
//
//        var errorResponse = new ErrorResponse(exception.getErrorCodes(), exception.getMessages());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
//            HttpServletRequest request, ResourceNotFoundException exception) {
//        log.error(
//                "{} Resource not found ; Request URI: {}",
//                exception.getErrorCodes(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = new ErrorResponse(exception.getErrorCodes(), exception.getMessages());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
//
//    /**
//     * Handle custom request param errors
//     */
//    @ExceptionHandler(InvalidRequestParamException.class)
//    public ResponseEntity<ErrorResponse> handleUnknownStatusException(
//            HttpServletRequest request, InvalidRequestParamException exception) {
//        log.error(
//                "{} Invalid status ; Request URI: {}",
//                ErrorCode.INVALID_STATUS_PARAM.getCode(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse =
//                new ErrorResponse(EnumSet.of(ErrorCode.INVALID_STATUS_PARAM), List.of(exception.getMessage()));
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
//            HttpServletRequest request, MethodArgumentNotValidException exception) {
//        log.error(
//                "{} Validation failed for request: {} ; Request URI: {}",
//                ErrorCode.VALIDATION_ERROR.getCode(),
//                exception.getParameter(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = createErrorResponse(exception, ErrorCode.VALIDATION_ERROR);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(BindException.class)
//    public ResponseEntity<ErrorResponse> handleBindException(HttpServletRequest request, BindException exception) {
//        log.error(
//                "{} Binding failed for request ; Request URI: {}",
//                ErrorCode.REQUEST_PARAMS_VALIDATION_ERROR.getCode(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = createErrorResponse(exception, ErrorCode.REQUEST_PARAMS_VALIDATION_ERROR);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    /**
//     * Handle missing request parameters exception
//     */
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<ErrorResponse> handleMissingRequestParameterException(
//            HttpServletRequest request, MissingServletRequestParameterException exception) {
//        log.error(
//                "{} Missing request parameter ; Request URI: {}",
//                ErrorCode.MISSING_REQUEST_PARAM.getCode(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = new ErrorResponse(
//                EnumSet.of(ErrorCode.MISSING_REQUEST_PARAM),
//                List.of("Missing request parameter: %s".formatted(exception.getParameterName())));
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    /** Handle Hibernate and @Validated errors and hide details */
////    @ExceptionHandler(ConstraintViolationException.class)
////    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
////            HttpServletRequest request, ConstraintViolationException exception) {
////        log.error(
////                "{} Constraint violation error ; Request URI: {}",
////                ErrorCode.VALIDATION_ERROR.getCode(),
////                request.getRequestURI(),
////                exception);
////
////        var errorResponse = new ErrorResponse(EnumSet.of(ErrorCode.VALIDATION_ERROR), Collections.emptyList());
////
////        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
////    }
//
//    /**
//     * Handle method argument type error (e.g request parameter type)
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
//            HttpServletRequest request, MethodArgumentTypeMismatchException exception) {
//        log.error(
//                "{} Method argument type error ;  Request URI: {}",
//                ErrorCode.INVALID_REQUEST_PARAM_TYPE.getCode(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = new ErrorResponse(
//                EnumSet.of(ErrorCode.INVALID_REQUEST_PARAM_TYPE),
//                List.of("Invalid type for property: %s ; with value: %s"
//                        .formatted(exception.getPropertyName(), exception.getValue())));
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    /**
//     * Handle any unhandled exceptions and hide details
//     */
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(HttpServletRequest request, Exception exception) {
//        log.error(
//                "{} Unhandled internal server error ; Request URI: {}",
//                ErrorCode.INTERNAL_SERVER_ERROR.getCode(),
//                request.getRequestURI(),
//                exception);
//
//        var errorResponse = new ErrorResponse(
//                EnumSet.of(ErrorCode.INTERNAL_SERVER_ERROR), List.of("Unexpected internal server error"));
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
//
//    private ErrorResponse createErrorResponse(BindException bindException, ErrorCode errorCode) {
//        var validationErrors = bindException.getBindingResult().getFieldErrors().stream()
//                .map(FieldError::getDefaultMessage)
//                .toList();
//
//        return new ErrorResponse(EnumSet.of(errorCode), validationErrors);
//    }
//}
//
