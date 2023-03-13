package toy.random_meal.category.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.random_meal.category.entity.Category;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryDto {

    private Long id;

    private String name;

    private CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryDto of(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

}
