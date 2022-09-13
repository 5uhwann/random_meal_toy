package toy.random_meal.domain.memberdomain.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
