package toy.random_meal.domain.mealdomain.meal;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryMealRepository implements MealRepository{

    private static final Map<Long, Meal> mealStore = new ConcurrentHashMap<>();
    private static final Map<Long, Meal> selectedMealStore = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();

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
    public Meal randomMealSave(Meal meal) {
        selectedMealStore.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public Meal findRandomMealById(Long id) {
        return selectedMealStore.get(id);
    }

    public void clear() {
          mealStore.clear();
      }
}
