package toy.random_meal.member.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserIdTest {

    @Test
    void 아이디생성_성공() {
        //given
        String userId = "testtest";

        //when
        UserId createdUserId = UserId.of(userId);

        //then
        assertThat(createdUserId.getUserId()).isEqualTo(userId);

    }

    @Test
    void 아이디생성_실패() {
        //given
        String userId = "test";

        //then
        assertThatThrownBy(() -> UserId.of(userId)).isInstanceOf(IllegalStateException.class);
    }

}
