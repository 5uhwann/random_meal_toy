package toy.random_meal.member.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void checkDuplicatedUserId(UserId userId) {
        List<Member> findMember = memberRepository.findByUserId(userId);
        if (!findMember.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    @Override
    public Long joinMember(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

}
