package toy.random_meal.domain.common;

import java.time.LocalDateTime;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

}
