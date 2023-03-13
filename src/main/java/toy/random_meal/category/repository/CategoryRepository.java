package toy.random_meal.category.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import toy.random_meal.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByMemberId(Long memberId);

}
