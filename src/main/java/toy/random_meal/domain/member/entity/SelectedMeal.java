package toy.random_meal.domain.member.entity;

import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class SelectedMeal {

    private String mealListName;

    private String mealName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SelectedMeal that = (SelectedMeal) o;
        return Objects.equals(getMealListName(), that.getMealListName()) && Objects.equals(
                getMealName(), that.getMealName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMealListName(), getMealName());
    }
}
