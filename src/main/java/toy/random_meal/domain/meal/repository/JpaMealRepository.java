package toy.random_meal.domain.meal.repository;

import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.random_meal.domain.meal.entity.Meal;

@Repository
@RequiredArgsConstructor
public class JpaMealRepository implements MealRepository {

    private final EntityManager em;

    @Override
    public Meal save(Meal meal) {
        em.persist(meal);
        return meal;
    }

    @Override
    public Meal findById(Long id) {
        return em.find(Meal.class, id);
    }

    @Override
    public List<Meal> findAll() {
        return em.createQuery("select m from Meal m", Meal.class)
                .getResultList();
    }

    @Override
    public void delete(Long id) {
        Meal findMeal = em.find(Meal.class, id);
        em.remove(findMeal);
    }
}
