package toy.random_meal.domain.member.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void 회원_생성() {
        //given
        String memberName = "5uhwann";
        Grade grade = Grade.Basic;

        //when
        Member createdMember = Member.builder()
                .memberName(memberName)
                .grade(grade).build();

        //then
        assertThat(createdMember.getName()).isEqualTo(memberName);
        assertThat(createdMember.getGrade()).isEqualTo(grade);
    }
}
