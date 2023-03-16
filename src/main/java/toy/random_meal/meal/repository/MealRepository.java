package toy.random_meal.meal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.mealinventory.entity.MealInventory;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByMealInventory(MealInventory mealInventory);

}
