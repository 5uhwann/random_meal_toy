package toy.random_meal.domain.mealdomain.randomMeal;

import org.springframework.stereotype.Service;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.mealdomain.meal.MealRepository;
import toy.random_meal.domain.memberdomain.member.Member;
import toy.random_meal.domain.memberdomain.member.MemberRepository;
import toy.random_meal.domain.mealdomain.ramdomMealAlgo.RandomMealAlgo;

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
    public Meal selectMeal() {
        ArrayList<Meal> meals = new ArrayList<>(mealRepository.findAll());
        Meal selectedMeal = randomMealAlgo.randomMealAlgo(meals);
        return selectedMeal;
    }
}
