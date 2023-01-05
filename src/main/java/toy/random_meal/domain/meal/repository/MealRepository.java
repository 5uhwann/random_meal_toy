package toy.random_meal.domain.meal.repository;

import java.util.List;
import toy.random_meal.domain.meal.entity.Meal;

public interface MealRepository {

    Meal save(Meal meal);

    Meal findById(Long id);

    List<Meal> findAll();

    void update(Long itemId, Meal updateParam);

    void delete(Long id);

    Meal saveSelectedMeal(Meal meal);

    Meal getSelectedMeal();

}
