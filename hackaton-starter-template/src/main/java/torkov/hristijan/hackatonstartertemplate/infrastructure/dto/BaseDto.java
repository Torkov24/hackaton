package torkov.hristijan.hackatonstartertemplate.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {
    protected UUID id;
    protected Instant createdAt;
}


