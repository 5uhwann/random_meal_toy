package toy.random_meal.domain.mealdomain.manageMeal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toy.random_meal.AutoAppConfig;
import toy.random_meal.domain.mealdomain.manageMeal.ManageMealService;
import toy.random_meal.domain.memberdomain.member.Grade;
import toy.random_meal.domain.memberdomain.member.Member;
import toy.random_meal.domain.memberdomain.member.MemberService;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class ManageMealServiceImplTest {

    @Test
    @DisplayName("프로 회원은 음식목록 추가 가능")
    void proMemberAddMealTest() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        ManageMealService manageMealService = ac.getBean(ManageMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "member", Grade.Pro);
        memberService.join(member);

        // when
        manageMealService.addMeal(member, "국밥");

        // then
        ArrayList<String> foodList = member.getFoodList();
        String addedMeal = foodList.get(foodList.size() - 1);
        assertThat(addedMeal).isEqualTo("국밥");
    }

    @Test
    @DisplayName("이미 존재하는 음식은 추가 불가")
    void addDuplicateMeal() {
        //given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        ManageMealService manageMealService = ac.getBean(ManageMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "member", Grade.Pro);
        memberService.join(member);

        int beforeFoodListSize = member.getFoodList().size();
        //when
        manageMealService.addMeal(member, "돈까스");

        //then
        assertThat(member.getFoodList().size()).isEqualTo(beforeFoodListSize);
    }

    @Test
    @DisplayName("기본 회원은 음식목록 추가 기능 사용 불가")
    void basicMemberAddMealTest() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        ManageMealService manageMealService = ac.getBean(ManageMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "member", Grade.Basic);
        memberService.join(member);
        int foodListSize = member.getFoodList().size();

        // when
        manageMealService.addMeal(member, "국밥");

        // then
        int addedFoodListSize = member.getFoodList().size();
        assertThat(addedFoodListSize).isEqualTo(foodListSize);
    }

    @Test
    @DisplayName("프로 회원은 음식목록 삭제 가능")
    void proMemberDeleteMeal() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        ManageMealService manageMealService = ac.getBean(ManageMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "member", Grade.Pro);
        memberService.join(member);
        int beforeFoodListSize = member.getFoodList().size();
        String meal = member.getFoodList().get(7);

        // when
        String deletedMeal = manageMealService.deleteMeal(member, "닭가슴살");

        // then
        assertThat(member.getFoodList().size()).isEqualTo(beforeFoodListSize - 1);
        assertThat(deletedMeal).isEqualTo(meal);
    }

    @Test
    @DisplayName("음식 목록에 존재하지 않는 음식은 삭제 불가")
    void deleteNonExistentFood() {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        ManageMealService manageMealService = ac.getBean(ManageMealService.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Member member = new Member(1L, "member", Grade.Basic);
        memberService.join(member);

        // when
        String deletedMeal = manageMealService.deleteMeal(member, "케익");

        // then
        assertThat(deletedMeal).isEqualTo(null);
    }
}