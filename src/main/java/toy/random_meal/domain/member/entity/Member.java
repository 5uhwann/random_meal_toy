package toy.random_meal.domain.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private LocalDateTime createdAt;

    private String name;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    //==생성 메서드==//
    public static Member createMember(String memberName, Grade grade) {
        Member member = new Member();
        member.name = memberName;
        member.grade = grade;
        return member;
    }
}
