package toy.random_meal.domain.meal.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import toy.random_meal.domain.meal.entity.Meal;

@Repository
public class MemoryMealRepository implements MealRepository{

    private static final Map<Long, Meal> mealStore = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();
    private static final ArrayList<Meal> selectedMealList = new ArrayList<>();

    private static int RANDOM_MEAL_INDEX = 0;
    // private static final Q
    @Override
    public Meal save(Meal meal) {
        meal.setId(sequence.incrementAndGet());
        mealStore.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public Meal findById(Long id) {
        return mealStore.get(id);
    }

    @Override
    public List<Meal> findAll() {
        return new ArrayList<>(mealStore.values());
    }

    @Override
    public void update(Long mealId, Meal updateParam) {
        Meal findMeal = mealStore.get(mealId);
        findMeal.setMealName(updateParam.getMealName());
        findMeal.setPrice(updateParam.getPrice());
        findMeal.setKcal(updateParam.getKcal());
    }

    @Override
    public void delete(Long id) {
        mealStore.remove(id);
    }

    @Override
    public Meal saveSelectedMeal(Meal meal) {
        selectedMealList.add(meal);
        return meal;
    }

    @Override
    public Meal getSelectedMeal(){
      Meal meal = selectedMealList.get(RANDOM_MEAL_INDEX);
      clearSelectedMeal();
      return meal;
    }

    private void clearSelectedMeal(){
      selectedMealList.clear();
    }

    public void clear() {
          mealStore.clear();
      }
}
