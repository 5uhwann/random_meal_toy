package toy.random_meal.domain.mealdomain.randomMeal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.mealdomain.meal.MemoryMealRepository;

import java.util.ArrayList;

class RandomMealServiceImplTest {

    MemoryMealRepository mealRepository = new MemoryMealRepository();

    @AfterEach
    void afterEach(){
      mealRepository.clearSelectedMeal();
    }

    @Test
    void selectMealTest() {
        //given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        RandomMealService randomMealService = ac.getBean(RandomMealService.class);

        Meal mealA = new Meal("A", 10000, 500);
        Meal mealB = new Meal("B", 11000, 600);
        Meal mealC = new Meal("C", 12000, 700);
        Meal mealD = new Meal("D", 13000, 800);
        Meal mealE = new Meal("E", 14000, 900);

        mealRepository.save(mealA);
        mealRepository.save(mealB);
        mealRepository.save(mealC);
        mealRepository.save(mealD);
        mealRepository.save(mealE);

        //when
        randomMealService.selectMeal();

        //then
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());
        Meal randomMeal = mealRepository.getSelectedMeal();
        Assertions.assertThat(meals).contains(randomMeal);
    }
}
