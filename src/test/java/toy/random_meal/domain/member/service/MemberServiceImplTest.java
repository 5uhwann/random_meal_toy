package toy.random_meal.domain.member.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.domain.member.entity.Grade;
import toy.random_meal.domain.member.entity.Member;
import toy.random_meal.domain.member.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = Member.createMember("5uhwann", Grade.Basic);

        //when
        Long joinedMemberId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(joinedMemberId);
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void 중복회원_가입() {
        //given
        Member memberA = Member.createMember("5uhwann", Grade.Pro);
        Member memberB = Member.createMember("5uhwann", Grade.Basic);

        memberService.join(memberA);

        //when //then
        assertThatThrownBy(() -> memberService.join(memberB)).isInstanceOf(IllegalStateException.class);
    }
}
