package toy.random_meal.manageMeal;

import toy.random_meal.member.Member;

public interface ManageMealService {

    void addMeal(Member member, String newMeal);

    String deleteMeal(Member member, String deleteMeal);
}
