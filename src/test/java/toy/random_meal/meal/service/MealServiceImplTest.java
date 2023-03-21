package toy.random_meal.meal.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.random_meal.category.entity.Category;
import toy.random_meal.category.sevice.CategoryService;
import toy.random_meal.meal.controller.dto.MealDto;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.mealinventory.service.MealInventoryService;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.service.MemberService;

@SpringBootTest
class MealServiceImplTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MealInventoryService mealInventoryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MealService mealService;

    @Test
    void 음식조회_음식목록() {
        //given
        Member member = createMember();
        memberService.joinMember(member);

        MealInventory inventory = createMealInventory(member);
        mealInventoryService.createMealInventory(inventory);

        Category categoryA = createCategory(member, "categoryA");
        Category categoryB = createCategory(member, "categoryB");
        categoryService.createCategory(categoryA);
        categoryService.createCategory(categoryB);

        Meal mealA = createMeal(inventory, categoryA, "mealA", 10000);
        Meal mealB = createMeal(inventory, categoryA, "mealB", 15000);
        mealService.createMeal(mealA);
        mealService.createMeal(mealB);

        //when
        List<MealDto> foundMeals = mealService.findAllByMealInventory(inventory);

        //then
        assertThat(foundMeals.isEmpty()).isFalse();
    }

    @Test
    void 음식조회_회원() {
        //given
        Member member = createMember();
        memberService.joinMember(member);

        MealInventory inventory = createMealInventory(member);
        mealInventoryService.createMealInventory(inventory);

        Category categoryA = createCategory(member, "categoryA");
        Category categoryB = createCategory(member, "categoryB");
        categoryService.createCategory(categoryA);
        categoryService.createCategory(categoryB);

        Meal mealA = createMeal(inventory, categoryA, "mealA", 10000);
        Meal mealB = createMeal(inventory, categoryA, "mealB", 15000);
        mealService.createMeal(mealA);
        mealService.createMeal(mealB);

        //when
        List<MealDto> foundMeals = mealService.findAllByMember(member);

        //then
        assertThat(foundMeals.isEmpty()).isFalse();
    }

    private static Meal createMeal(MealInventory inventory, Category categoryA, String name, int price) {
        Meal meal = Meal.builder()
                .mealInventory(inventory)
                .category(categoryA)
                .name(name)
                .price(price).build();
        return meal;
    }

    private static Category createCategory(Member member, String name) {
        Category category = Category.builder()
                .member(member)
                .name(name).build();
        return category;
    }

    private static MealInventory createMealInventory(Member member) {
        MealInventory inventory = MealInventory.builder()
                .name("testInventory")
                .member(member).build();
        return inventory;
    }

    private static Member createMember() {
        Member member = Member.builder()
                .name("5uhwann")
                .userId(UserId.from("testtest"))
                .password("1234").build();
        return member;
    }

}
