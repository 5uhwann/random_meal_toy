package toy.random_meal.domain.meal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toy.random_meal.domain.meal.entity.Meal;
import toy.random_meal.domain.meal.repository.MealRepository;

@Component
public class ManageMealServiceImpl implements ManageMealService{

    private final MealRepository mealRepository;

    @Autowired
    public ManageMealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal addMeal(Meal meal) {
        Meal addedMeal = mealRepository.save(meal);
        return addedMeal;
    }

    @Override
    public void deleteMeal(Long id) {
        mealRepository.delete(id);
    }

    @Override
    public void editMeal(Long id, Meal updateParam) {
        mealRepository.update(id, updateParam);
    }

//    private static boolean isMemberPro(Member findMember) {
//        return findMember.getGrade() == Grade.Pro;
//    }
//
//    private static boolean isMealContains(String meal, ArrayList<String> foodList) {
//        return foodList.contains(meal);
//    }
}
