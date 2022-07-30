package toy.random_meal.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
