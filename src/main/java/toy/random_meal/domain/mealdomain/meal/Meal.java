package toy.random_meal.domain.mealdomain.meal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Meal {

    private Long id;
    private String mealName;
    private int price;
    private int kcal;

    public Meal() {
    }

    public Meal(String mealName, int price, int kcal) {
        this.mealName = mealName;
        this.price = price;
        this.kcal = kcal;
    }
}
