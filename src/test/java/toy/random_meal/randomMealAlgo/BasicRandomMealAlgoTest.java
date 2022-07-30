package toy.random_meal.randomMealAlgo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toy.random_meal.member.Grade;
import toy.random_meal.member.Member;
import toy.random_meal.ramdomMealAlgo.BasicRandomMealAlgo;
import toy.random_meal.ramdomMealAlgo.RandomMealAlgo;

import static org.assertj.core.api.Assertions.*;

public class BasicRandomMealAlgoTest {

    @Test
    @DisplayName("회원 기본음식 목록의 크기 내의 랜덤 숫자 생성")
    void basicAlgoTest() {
        //given
        Member member = new Member(1L, "member", Grade.Basic);
        String[] mealList = member.getBasicFood();
        //when
        int randomIndex = (int)((Math.random())*(mealList.length+1));

        //then
        assertThat(randomIndex).isGreaterThanOrEqualTo(0);
        assertThat(randomIndex).isLessThanOrEqualTo(mealList.length);
    }
}
