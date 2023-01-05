package toy.random_meal.domain.meal.service;

import org.springframework.stereotype.Service;
import toy.random_meal.domain.meal.entity.Meal;
import toy.random_meal.domain.meal.repository.MealRepository;
import toy.random_meal.domain.meal.service.ramdomMealAlgo.RandomMealAlgo;

import java.util.ArrayList;

@Service
public class RandomMealServiceImpl implements RandomMealService{

    private final MealRepository mealRepository;
    private final RandomMealAlgo randomMealAlgo;

    public RandomMealServiceImpl(MealRepository mealRepository, RandomMealAlgo randomMealAlgo) {
        this.mealRepository = mealRepository;
        this.randomMealAlgo = randomMealAlgo;
    }

    @Override
    public void selectMeal() {
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());
        Meal selectedMeal = randomMealAlgo.randomMealAlgo(meals);
        mealRepository.saveSelectedMeal(selectedMeal);
    }
}
