package toy.random_meal.member.entity;

import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId {

    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 20;

    private String userId;

    private UserId(String userId) {
        this.userId = userId;
    }

    public static UserId from(String id) {
        validateId(id);
        return new UserId(id);
    }

    private static void validateId(String id) {
        Assert.notNull(id, "아이디는 필수입니다.");
        if (id.length() < MIN_LENGTH || id.length() > MAX_LENGTH) {
            throw new IllegalStateException("아이디는 6~20자 사이의 길이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId memberId = (UserId) o;
        return Objects.equals(getUserId(), memberId.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
