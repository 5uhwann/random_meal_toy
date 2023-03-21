package toy.random_meal.meal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMealRequest {

    private String name;

    private Long mealInventoryId;

    private Long categoryId;

    private int price;

}
