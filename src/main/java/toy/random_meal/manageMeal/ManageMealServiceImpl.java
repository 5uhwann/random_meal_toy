package toy.random_meal.manageMeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toy.random_meal.member.Grade;
import toy.random_meal.member.Member;
import toy.random_meal.member.MemberRepository;

import java.util.ArrayList;

@Component
public class ManageMealServiceImpl implements ManageMealService{

    private final MemberRepository memberRepository;

    @Autowired
    public ManageMealServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void addMeal(Member member, String newMeal) {
        Member findMember = memberRepository.findById(member.getId());
        if (findMember.getGrade() == Grade.Pro) {
            ArrayList<String> foodList = findMember.getFoodList();
            foodList.add(newMeal);
            findMember.setFoodList(foodList);
        }else{
            System.out.println("프로만 이용가능");
            return;
        }

    }

    @Override
    public String deleteMeal(Member member, String deleteMeal) {
        return null;
    }
}
