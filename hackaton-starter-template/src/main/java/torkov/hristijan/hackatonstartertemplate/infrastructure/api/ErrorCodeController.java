//package torkov.hristijan.hackatonstartertemplate.infrastructure.api;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.Collection;
//
//@RestController
//@RequestMapping(Endpoints.ERROR_CODES)
//public class ErrorCodeController extends BaseController {
//
//    @GetMapping
//    public BaseResponse<Collection<ErrorCodeDto>> getErrorCodes() {
//        var errorCodes = Arrays.stream(ErrorCode.values())
//                .map(errorCode -> new ErrorCodeDto(errorCode.getCode(), errorCode.getMessage()))
//                .toList();
//
//        return ok(errorCodes);
//    }
//}
//
