package toy.random_meal.domain.member.entity;

import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class SelectedMeal {

    private String mealListName;

    private String mealName;

}
