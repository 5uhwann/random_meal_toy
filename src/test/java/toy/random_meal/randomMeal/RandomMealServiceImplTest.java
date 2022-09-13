package toy.random_meal.randomMeal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.domain.mealdomain.randomMeal.RandomMealService;
import toy.random_meal.domain.memberdomain.member.Grade;
import toy.random_meal.domain.memberdomain.member.Member;
import toy.random_meal.domain.memberdomain.member.MemberService;

import java.util.ArrayList;
import java.util.Arrays;

class RandomMealServiceImplTest {

    @Test
    @DisplayName("randomMealAlgo()에서 선택된 음식은 기본음식목록 중 하나다.")
    void selectMealTest() {
        //given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        RandomMealService randomMealService = ac.getBean(RandomMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member(1L, "member", Grade.Basic);
        memberService.join(member);
        String[] testFood = {"a", "a", "a", "a", "a", "a", "a", "a", "a" };
        ArrayList<String> basicFoodList = new ArrayList<>(Arrays.asList(testFood));
        member.setFoodList(basicFoodList);


        //when
        String selectedMeal = randomMealService.selectMeal(1L);

        //then
        Assertions.assertThat(selectedMeal).isEqualTo("a");
    }
}