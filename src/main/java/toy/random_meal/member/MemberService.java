package toy.random_meal.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
