package toy.random_meal.domain.mealdomain.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryMealRepository implements MealRepository{

    private static final Map<Long, Meal> mealStore = new ConcurrentHashMap<>();
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
        findMeal.setPrice(updateParam.getKcal());
        findMeal.setPrice(updateParam.getPrice());
    }

    @Override
    public void delete(Long id) {
        mealStore.remove(id);
    }

    public void clear() {
        mealStore.clear();
    }
}
