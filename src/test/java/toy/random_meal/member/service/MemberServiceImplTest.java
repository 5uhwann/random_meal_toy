package toy.random_meal.member.service;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    void 아이디중복체크_실패() {
        //given
        Member memberA = Member.builder()
                .name("5uhwann")
                .userId(UserId.of("testtest"))
                .password("1234").build();

        memberService.joinMember(memberA);

        //when //then
        assertThatThrownBy(() -> memberService.checkDuplicatedUserId(UserId.of("testtest")))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
