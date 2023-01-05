package toy.random_meal.domain.member.service;

import toy.random_meal.domain.member.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
