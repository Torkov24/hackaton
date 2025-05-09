package torkov.hristijan.hackatonstartertemplate.infrastructure.domain;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class BaseEntity {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
    private UUID id;

    //    @Column(name = "created_at", updatable = false)
    private Instant createdAt = Instant.now();
}

