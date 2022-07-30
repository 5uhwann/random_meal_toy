package toy.random_meal.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;
    private String[] basicFood = {"돈까스", "치킨", "피자", "라면", "햄버거", "고기", "빵", "닭가슴살", "파스타" };

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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

    public String[] getBasicFood() {
        return basicFood;
    }

    public void setBasicFood(String[] basicFood) {
        this.basicFood = basicFood;
    }
}
