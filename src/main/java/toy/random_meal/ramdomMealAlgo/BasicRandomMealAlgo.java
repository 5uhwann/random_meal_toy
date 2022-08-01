package toy.random_meal.ramdomMealAlgo;

import org.springframework.stereotype.Component;
import toy.random_meal.member.Member;

@Component
public class BasicRandomMealAlgo implements RandomMealAlgo{

    @Override
    public String randomMealAlgo(Member member) {
        String[] mealList = member.getBasicFood();
        int randomIndex = (int)((Math.random())*(mealList.length+1));
        return mealList[randomIndex];
    }
}
