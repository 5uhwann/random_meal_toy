package toy.random_meal.domain.memberdomain.member;

import java.util.ArrayList;
import java.util.Arrays;

public class Member {

    private Long id;
    private String name;
    private Grade grade;
    private String[] basicFood = {"돈까스", "치킨", "피자", "라면", "햄버거", "고기", "빵", "닭가슴살", "파스타" };
    private ArrayList<String> basicFoodList;



    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.basicFoodList = new ArrayList<>(Arrays.asList(this.basicFood));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public ArrayList<String> getFoodList() {
        return basicFoodList;
    }

    public void setFoodList(ArrayList<String> basicFoodList) {
        this.basicFoodList = basicFoodList;
    }
}
