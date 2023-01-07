package toy.random_meal.domain.member.repository;

import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.random_meal.domain.member.entity.Member;

@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Member findById(Long memberId) {
        return em.find(Member.class, memberId);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
