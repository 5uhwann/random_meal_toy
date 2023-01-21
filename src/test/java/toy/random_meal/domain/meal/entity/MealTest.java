package toy.random_meal.domain.meal.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import toy.random_meal.domain.meallist.entity.MealList;

class MealTest {

    @Test
    void 음식_생성() {
        //given
        MealList meals = new MealList();
        Category category = new Category();

        //when
        Meal createdMeal = Meal.builder()
                .meals(meals)
                .category(category)
                .price(10000)
                .name("돈까스")
                .kcal(500).build();
        //then
        assertThat(createdMeal.getMeals()).isEqualTo(meals);
        assertThat(createdMeal.getCategory()).isEqualTo(category);
    }


}
