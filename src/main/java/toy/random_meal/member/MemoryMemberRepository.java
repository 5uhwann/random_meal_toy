package toy.random_meal.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> memberHouse = new HashMap<>();


    @Override
    public void save(Member member) {
        memberHouse.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        Member member = memberHouse.get(memberId);
        return member;
    }
}