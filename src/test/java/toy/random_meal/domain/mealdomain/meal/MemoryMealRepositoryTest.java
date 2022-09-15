package toy.random_meal.domain.mealdomain.meal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMealRepositoryTest {

   MemoryMealRepository mealRepository = new MemoryMealRepository();

    @AfterEach
    void afterEach() {
        mealRepository.clear();
    }

    @Test
    void saveTest() {

        //given
        Meal meal = new Meal("돈까스", 10000, 700);

        //when
        mealRepository.save(meal);

        //then
        Meal findMeal = mealRepository.findById(meal.getId());
        assertThat(meal).isEqualTo(findMeal);
    }

    @Test
    void findAllTest() {

        //given
        Meal meal1 = new Meal("돈까스", 10000, 450);
        Meal meal2 = new Meal("초밥", 15000, 650);

        mealRepository.save(meal1);
        mealRepository.save(meal2);

        //when
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());

        //then
        assertThat(meals).contains(meal1);
        assertThat(meals).contains(meal2);
    }

    @Test
    void updateTest() {

        //given
        Meal meal1 = new Meal("돈까스", 10000, 450);
        mealRepository.save(meal1);
        Long itemId = meal1.getId();

        //when
        Meal updateParam = new Meal("초밥", 15000, 650);
        mealRepository.update(itemId, updateParam);

        //then
        Meal findMeal = mealRepository.findById(itemId);
        assertThat(findMeal.getMealName()).isEqualTo(updateParam.getMealName());
        assertThat(findMeal.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findMeal.getKcal()).isEqualTo(updateParam.getKcal());
    }

    @Test
    void deleteTest() {

        //given
        Meal meal1 = new Meal("돈까스", 10000, 450);
        Meal meal2 = new Meal("초밥", 15000, 650);

        mealRepository.save(meal1);
        mealRepository.save(meal2);

        //when
        mealRepository.delete(meal1.getId());

        //then
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());
        assertThat(meals).doesNotContain(meal1);
    }


}