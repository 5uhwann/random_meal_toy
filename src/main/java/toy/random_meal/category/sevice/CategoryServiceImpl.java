package toy.random_meal.category.sevice;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.category.controller.dto.CategoryDto;
import toy.random_meal.category.entity.Category;
import toy.random_meal.category.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Long save(Category category) {
        categoryRepository.save(category);
        return category.getId();
    }

    @Override
    public List<CategoryDto> findByMemberId(Long memberId) {
         return categoryRepository.findByMemberId(memberId).stream()
                 .map(CategoryDto::of)
                 .collect(Collectors.toList());
    }
}
