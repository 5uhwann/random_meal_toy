package toy.random_meal.domain.mealdomain.ramdomMealAlgo;

import org.springframework.stereotype.Component;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.memberdomain.member.Member;

import java.util.ArrayList;

@Component
public class BasicRandomMealAlgo implements RandomMealAlgo{

    @Override
    public Meal randomMealAlgo(ArrayList<Meal> meals) {
        int randomIndex = getRandomIndex(meals);
        return meals.get(randomIndex);
    }

    private int getRandomIndex(ArrayList<Meal> basicFoodList) {
        int randomIndex = (int)((Math.random())*(basicFoodList.size()));
        return randomIndex;
    }
}
