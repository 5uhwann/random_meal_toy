package toy.random_meal.meal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByMealInventory(MealInventory mealInventory);

    @Query("select m from Meal m join fetch m.mealInventory ml where ml.member = :mb")
    List<Meal> findAll(@Param("mb") Member member);

}
