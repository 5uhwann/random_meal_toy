package toy.random_meal.domain.meal.randomMeal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.domain.meal.entity.Meal;
import toy.random_meal.domain.meal.repository.MemoryMealRepository;

import java.util.ArrayList;
import toy.random_meal.domain.meal.service.RandomMealService;

class RandomMealServiceImplTest {

    MemoryMealRepository mealRepository = new MemoryMealRepository();

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
