//package torkov.hristijan.hackatonstartertemplate.infrastructure.dto;
//
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//import java.time.Instant;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Data
//@RequiredArgsConstructor
//public class ErrorResponse {
//    private final Collection<String> codes;
//    private final Collection<String> messages;
//    private final Collection<String> details;
//
//    private Instant timestamp = Instant.now();
//
//    public ErrorResponse(Collection<ErrorCode> errorCodes, Collection<String> details) {
//        this.codes = errorCodes.stream().map(ErrorCode::getCode).collect(Collectors.toSet());
//        this.messages = errorCodes.stream().map(ErrorCode::getMessage).collect(Collectors.toSet());
//        this.details = details;
//    }
//}
//
//
