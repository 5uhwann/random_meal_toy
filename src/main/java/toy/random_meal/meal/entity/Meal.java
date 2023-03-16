package toy.random_meal.meal.entity;

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
import toy.random_meal.category.entity.Category;
import toy.random_meal.common.entity.BaseEntity;
import toy.random_meal.mealinventory.entity.MealInventory;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Meal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_inventory_id")
    private MealInventory mealInventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "category_name")
    private String name;

    private int price;

    private int selectedCount;


    @Builder
    public Meal(MealInventory mealInventory, Category category, String name, int price) {
        this.mealInventory = mealInventory;
        this.category = category;
        this.name = name;
        this.price = price;
        this.selectedCount = 0;
    }
}
