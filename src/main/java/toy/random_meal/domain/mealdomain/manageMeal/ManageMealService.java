package toy.random_meal.domain.mealdomain.manageMeal;

import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.memberdomain.member.Member;

public interface ManageMealService {

    Meal addMeal(Meal meal);

    void deleteMeal(Long id);

    void editMeal(Long id, Meal updateParam);
}
