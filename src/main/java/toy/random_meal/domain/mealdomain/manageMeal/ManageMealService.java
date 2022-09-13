package toy.random_meal.domain.mealdomain.manageMeal;

import toy.random_meal.domain.memberdomain.member.Member;

public interface ManageMealService {

    void addMeal(Member member, String newMeal);

    String deleteMeal(Member member, String deleteMeal);
}
