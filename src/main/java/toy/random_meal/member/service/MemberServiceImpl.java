package toy.random_meal.member.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.member.controller.dto.DuplicatedUserIdResponse;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public DuplicatedUserIdResponse checkDuplicatedUserId(UserId userId) {
        List<Member> findMember = memberRepository.findByUserId(userId);
        if (!findMember.isEmpty()) {
            return new DuplicatedUserIdResponse(userId.getUserId(), false);
        }
        return new DuplicatedUserIdResponse(userId.getUserId(), true);
    }

    @Override
    @Transactional
    public Long joinMember(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

}
