package toy.random_meal.mealinventory.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;

public interface MealInventoryRepository extends JpaRepository<MealInventory, Long> {

    List<MealInventory> findByMember(Member member);

}
