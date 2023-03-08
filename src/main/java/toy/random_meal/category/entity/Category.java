package toy.random_meal.category.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import toy.random_meal.common.entity.BaseEntity;

@Entity
@Getter
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cateogry_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

}
