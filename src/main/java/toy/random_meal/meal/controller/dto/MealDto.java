package toy.random_meal.meal.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import toy.random_meal.meal.entity.Meal;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MealDto {

    private final Long id;

    private final String name;

    private final int price;

    private final int selectedCount;

    public static MealDto from(Meal meal) {
        return new MealDto(meal.getId(), meal.getName(), meal.getPrice(), meal.getSelectedCount());
    }

}
