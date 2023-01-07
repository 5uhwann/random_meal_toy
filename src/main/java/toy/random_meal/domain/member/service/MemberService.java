package toy.random_meal.domain.member.service;

import java.util.List;
import toy.random_meal.domain.member.entity.Member;

public interface MemberService {

    Long join(Member member);

    List<Member> findAll();

    Member findMember(Long memberId);
}
