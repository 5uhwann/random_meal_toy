package toy.random_meal.domain.meal.repository;

import java.util.List;
import toy.random_meal.domain.meal.entity.Meal;

public interface MealRepository {

    Meal save(Meal meal);

    Meal findById(Long id);

    List<Meal> findAll();

    void delete(Long id);

}
