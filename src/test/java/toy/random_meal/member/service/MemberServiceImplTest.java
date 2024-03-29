package toy.random_meal.member.service;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.member.controller.dto.DuplicatedUserIdResponse;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;


    @Test
    void 아이디중복체크_성공() {
        //given
        Member memberA = Member.builder()
                .name("5uhwann")
                .userId(UserId.from("testtest"))
                .password("1234").build();

        memberService.joinMember(memberA);

        //when
        DuplicatedUserIdResponse response = memberService.checkDuplicatedUserId(UserId.from("testtesttest"));

        //then
        assertThat(response.isDuplicatedUserId()).isTrue();

    }
    @Test
    void 아이디중복체크_실패() {
        //given
        Member memberA = Member.builder()
                .name("5uhwann")
                .userId(UserId.from("testtest"))
                .password("1234").build();

        memberService.joinMember(memberA);

        //when
        DuplicatedUserIdResponse response = memberService.checkDuplicatedUserId(UserId.from("testtest"));

        //then
        assertThat(response.isDuplicatedUserId()).isFalse();

    }

}
