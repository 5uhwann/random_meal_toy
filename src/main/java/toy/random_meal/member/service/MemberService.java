package toy.random_meal.member.service;

import toy.random_meal.member.controller.dto.DuplicatedUserIdResponse;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;

public interface MemberService {

    DuplicatedUserIdResponse checkDuplicatedUserId(UserId userId);

    Long joinMember(Member member);

}
