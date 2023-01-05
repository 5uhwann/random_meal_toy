package toy.random_meal.domain.member.service;

import org.springframework.stereotype.Component;
import toy.random_meal.domain.member.entity.Member;
import toy.random_meal.domain.member.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        Member member = memberRepository.findById(memberId);
        return member;
    }
}
