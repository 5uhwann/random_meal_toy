package toy.random_meal.category.sevice;

import java.util.List;
import toy.random_meal.category.controller.dto.CategoryDto;
import toy.random_meal.category.entity.Category;

public interface CategoryService {

    Long createCategory(Category category);

    List<CategoryDto> findByMemberId(Long memberId);

    void delete(Category category);

}
