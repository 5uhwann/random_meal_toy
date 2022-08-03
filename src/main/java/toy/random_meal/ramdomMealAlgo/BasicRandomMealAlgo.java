package toy.random_meal.ramdomMealAlgo;

import org.springframework.stereotype.Component;
import toy.random_meal.member.Member;

import java.util.ArrayList;

@Component
public class BasicRandomMealAlgo implements RandomMealAlgo{

    @Override
    public String randomMealAlgo(Member member) {
        ArrayList<String> basicFoodList = member.getFoodList();
        int randomIndex = (int)((Math.random())*(basicFoodList.size()+1));
        return basicFoodList.get(randomIndex);
    }
}
