package toy.random_meal.mealinventory.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMealInventoryRequest {

    private Long memberId;

    private String mealInventoryName;

}
