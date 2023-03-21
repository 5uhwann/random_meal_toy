package toy.random_meal.meal.service;

import java.util.List;
import toy.random_meal.meal.controller.dto.MealDto;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;

public interface MealService {

    Long createMeal(Meal meal);

    List<MealDto> findAllByMealInventory(MealInventory mealInventory);

    void delete(Meal meal);

    List<MealDto> findAllByMember(Member member);
}
