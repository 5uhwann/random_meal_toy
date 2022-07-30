package toy.random_meal.memberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.member.Grade;
import toy.random_meal.member.Member;
import toy.random_meal.member.MemberService;

public class MemberServiceTest {

    @Test
    @DisplayName("회원가입")
    void joinTest() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member memberA = new Member(1L, "memberA", Grade.Basic);

        //when
        memberService.join(memberA);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(memberA).isEqualTo(findMember);
    }
}
