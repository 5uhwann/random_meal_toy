package toy.random_meal.mealinventory.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import toy.random_meal.mealinventory.entity.MealInventory;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MealInventoryDto {

    private final Long id;

    private final String name;

    private final int numberOfUse;

    public static MealInventoryDto from(MealInventory mealInventory) {
        return new MealInventoryDto(mealInventory.getId(), mealInventory.getName(), mealInventory.getNumberOfUse());
    }

}
