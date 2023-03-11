package toy.random_meal.member.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DuplicatedUserIdResponse {

    private final String userId;

    private final boolean isDuplicatedUserId;

}
