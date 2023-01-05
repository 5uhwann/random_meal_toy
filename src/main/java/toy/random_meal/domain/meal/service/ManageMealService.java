package toy.random_meal.domain.meal.service;

import toy.random_meal.domain.meal.entity.Meal;

public interface ManageMealService {

    Meal addMeal(Meal meal);

    void deleteMeal(Long id);

    void editMeal(Long id, Meal updateParam);
}
