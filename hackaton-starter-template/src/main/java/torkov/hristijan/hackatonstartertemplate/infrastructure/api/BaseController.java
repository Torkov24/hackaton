package torkov.hristijan.hackatonstartertemplate.infrastructure.api;

import java.time.Instant;

public abstract class BaseController {
    protected BaseController() {
    }

    protected static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(data);
    }

    public record BaseResponse<T>(T data, Instant creationDate) {
        public BaseResponse(T data) {
            this(data, Instant.now());
        }
    }
}
