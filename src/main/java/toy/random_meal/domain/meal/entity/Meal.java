package toy.random_meal.domain.meal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toy.random_meal.domain.common.BaseEntity;
import toy.random_meal.domain.meallist.entity.MealList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_list_id")
    private MealList meals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private int price;
    private int kcal;

    //==생성 메서드==//
    @Builder
    public  Meal (MealList meals, Category category, String name, int price, int kcal) {
        this.meals = meals;
        this.category = category;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }
}
