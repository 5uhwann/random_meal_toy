package toy.random_meal.domain.meal.manageMeal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.domain.meal.entity.Meal;
import toy.random_meal.domain.meal.repository.MemoryMealRepository;

import java.util.ArrayList;
import toy.random_meal.domain.meal.service.ManageMealService;

import static org.assertj.core.api.Assertions.*;

class ManageMealServiceImplTest {

    ManageMealService manageMealService;
    MemoryMealRepository mealRepository = new MemoryMealRepository();

    @BeforeEach
    void beforeEach() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        manageMealService = ac.getBean(ManageMealService.class);
    }

    @AfterEach
    void afterEach() {
        mealRepository.clear();
    }

    @Test
    void addMealTest() {
        // given
        Meal newMeal = new Meal("돈까스", 10000, 600);

        // when
        manageMealService.addMeal(newMeal);

        // then
        Meal findMeal = mealRepository.findById(newMeal.getId());
        assertThat(newMeal).isEqualTo(findMeal);
    }

    @Test
    void deleteMealTest() {
        //given
        Meal meal1 = new Meal("돈까스", 10000, 600);
        Meal meal2 = new Meal("칼국수", 8000, 550);

        manageMealService.addMeal(meal1);
        manageMealService.addMeal(meal2);

        //when
        manageMealService.deleteMeal(meal2.getId());

        //then
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());
        assertThat(meals.size()).isEqualTo(1);
        assertThat(meals).doesNotContain(meal2);
    }

    @Test
    void editMeal() {
        //given
        Meal meal1 = new Meal("돈까스", 10000, 600);
        Meal meal2 = new Meal("칼국수", 8000, 550);

        manageMealService.addMeal(meal1);
        manageMealService.addMeal(meal2);

        Meal updateParam = new Meal("치즈 돈까스", 15000, 700);

        //when
        manageMealService.editMeal(meal1.getId(), updateParam);

        //then
        assertThat(meal1.getMealName()).isEqualTo(updateParam.getMealName());
        assertThat(meal1.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(meal1.getKcal()).isEqualTo(updateParam.getKcal());
    }
}
