package toy.random_meal.member.service;

import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;

public interface MemberService {

    void checkDuplicatedUserId(UserId userId);

    Long joinMember(Member member);

}
