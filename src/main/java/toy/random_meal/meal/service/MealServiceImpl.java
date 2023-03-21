package toy.random_meal.meal.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.meal.controller.dto.MealDto;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.meal.repository.MealRepository;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepository;

    @Override
    @Transactional
    public Long createMeal(Meal meal) {
        mealRepository.save(meal);
        return meal.getId();
    }

    @Override
    public List<MealDto> findAllByMealInventory(MealInventory mealInventory) {
        return mealRepository.findByMealInventory(mealInventory).stream()
                .map(MealDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    @Override
    public List<MealDto> findAllByMember(Member member) {
        return mealRepository.findAll(member).stream()
                .map(MealDto::from)
                .collect(Collectors.toList());
    }

}
