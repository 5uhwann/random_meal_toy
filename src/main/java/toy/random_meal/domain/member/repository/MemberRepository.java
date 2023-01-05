package toy.random_meal.domain.member.repository;

import toy.random_meal.domain.member.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
