package toy.random_meal.domain.mealdomain.meal;

import java.util.List;

public interface MealRepository {

    Meal save(Meal meal);

    Meal findById(Long id);

    List<Meal> findAll();

    void update(Long itemId, Meal updateParam);

    void delete(Long id);

    Meal saveSelectedMeal(Meal meal);

    Meal getSelectedMeal();

}
