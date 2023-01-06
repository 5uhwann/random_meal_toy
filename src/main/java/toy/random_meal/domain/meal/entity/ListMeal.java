package toy.random_meal.domain.meal.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class ListMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "list_meal_id")
    private Long id;

    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "meal_list_id")
    private MealList mealList;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

}
