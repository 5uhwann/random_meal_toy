package toy.random_meal.category.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateCategoryRequest {

    private Long memberId;

    private String categoryName;

}
