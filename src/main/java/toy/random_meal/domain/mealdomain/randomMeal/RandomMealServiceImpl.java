package toy.random_meal.domain.mealdomain.randomMeal;

import org.springframework.stereotype.Component;
import toy.random_meal.domain.memberdomain.member.Member;
import toy.random_meal.domain.memberdomain.member.MemberRepository;
import toy.random_meal.domain.mealdomain.ramdomMealAlgo.RandomMealAlgo;

@Component
public class RandomMealServiceImpl implements RandomMealService{

    private final MemberRepository memberRepository;
    private final RandomMealAlgo randomMealAlgo;

    public RandomMealServiceImpl(MemberRepository memberRepository, RandomMealAlgo randomMealAlgo) {
        this.memberRepository = memberRepository;
        this.randomMealAlgo = randomMealAlgo;
    }

    @Override
    public String selectMeal(Long id) {
        Member member = memberRepository.findById(id);
        String selectedMeal = randomMealAlgo.randomMealAlgo(member);
        return selectedMeal;
    }
}
