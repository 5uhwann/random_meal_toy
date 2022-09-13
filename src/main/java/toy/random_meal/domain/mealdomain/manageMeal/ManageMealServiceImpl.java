package toy.random_meal.domain.mealdomain.manageMeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import toy.random_meal.domain.memberdomain.member.Grade;
import toy.random_meal.domain.memberdomain.member.Member;
import toy.random_meal.domain.memberdomain.member.MemberRepository;

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
        if (isMemberPro(findMember)) {
            ArrayList<String> foodList = findMember.getFoodList();
            if (isMealContains(newMeal, foodList)) {
                System.out.println("이미 존재하는 음식");
            } else{
                foodList.add(newMeal);
                findMember.setFoodList(foodList);
            }
        }else{
            System.out.println("프로만 이용가능");
        }

    }

    @Override
    public String deleteMeal(Member member, String deleteMeal) {
        Member findMember = memberRepository.findById(member.getId());
        if(isMemberPro(findMember)){
            ArrayList<String> foodList = findMember.getFoodList();
            if(isMealContains(deleteMeal, foodList)){
                foodList.remove(deleteMeal);
                return deleteMeal;
            }else{
                System.out.println("해당 음식이 존재하지 않음");
                return null;
            }
        }else{
            System.out.println("프로만 이용가능");
            return null;
        }
    }

    private static boolean isMemberPro(Member findMember) {
        return findMember.getGrade() == Grade.Pro;
    }

    private static boolean isMealContains(String meal, ArrayList<String> foodList) {
        return foodList.contains(meal);
    }
}
