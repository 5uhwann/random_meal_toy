package toy.random_meal.member.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUserId(UserId userId);
}
