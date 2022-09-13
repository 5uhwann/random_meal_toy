package toy.random_meal.domain.mealdomain.ramdomMealAlgo;

import org.springframework.stereotype.Component;
import toy.random_meal.domain.memberdomain.member.Member;

import java.util.ArrayList;

@Component
public class BasicRandomMealAlgo implements RandomMealAlgo{

    @Override
    public String randomMealAlgo(Member member) {
        ArrayList<String> basicFoodList = member.getFoodList();
        int randomIndex = getRandomIndex(basicFoodList);
        return basicFoodList.get(randomIndex);
    }

    private static int getRandomIndex(ArrayList<String> basicFoodList) {
        int randomIndex = (int)((Math.random())*(basicFoodList.size()+1));
        return randomIndex;
    }
}
