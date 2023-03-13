package toy.random_meal.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import toy.random_meal.member.controller.dto.DuplicatedUserIdResponse;
import toy.random_meal.member.controller.dto.MemberInfo;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.OK)
    public void signUp(@RequestBody MemberInfo memberInfo) {
        Member member = Member.builder()
                .name(memberInfo.getName())
                .userId(UserId.from(memberInfo.getUserId()))
                .password(memberInfo.getPassword()).build();

        memberService.joinMember(member);
    }

    @PostMapping("/sign-up/check-duplicated")
    @ResponseStatus(HttpStatus.OK)
    public DuplicatedUserIdResponse checkDuplicatedId(@RequestBody UserId userId) {
        return memberService.checkDuplicatedUserId(userId);
    }

}
