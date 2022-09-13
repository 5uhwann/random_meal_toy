package toy.random_meal.randomMealAlgo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toy.random_meal.domain.memberdomain.member.Grade;
import toy.random_meal.domain.memberdomain.member.Member;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class BasicRandomMealAlgoTest {

    @Test
    @DisplayName("회원 기본음식 목록의 크기 내의 랜덤 숫자 생성")
    void basicAlgoTest() {
        //given
        Member member = new Member(1L, "member", Grade.Basic);
        ArrayList<String> mealList = member.getFoodList();
        //when
        int randomIndex = (int)((Math.random())*(mealList.size()+1));

        //then
        assertThat(randomIndex).isGreaterThanOrEqualTo(0);
        assertThat(randomIndex).isLessThanOrEqualTo(mealList.size());
    }
}
