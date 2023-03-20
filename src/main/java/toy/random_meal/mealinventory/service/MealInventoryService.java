package toy.random_meal.mealinventory.service;

import java.util.List;
import toy.random_meal.mealinventory.controller.dto.MealInventoryDto;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;

public interface MealInventoryService {

    Long createMealInventory(MealInventory mealInventory);

    List<MealInventoryDto> findAllByMember(Member member);

    MealInventoryDto updateName(MealInventory mealInventory, String beforeName, String updateName);

}
