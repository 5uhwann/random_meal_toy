package toy.random_meal.meal.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import toy.random_meal.category.entity.Category;
import toy.random_meal.category.repository.CategoryRepository;
import toy.random_meal.meal.controller.dto.CreateMealRequest;
import toy.random_meal.meal.controller.dto.MealDto;
import toy.random_meal.meal.entity.Meal;
import toy.random_meal.meal.service.MealService;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.mealinventory.repository.MealInventoryRepository;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meals")
public class MealApiController {

    private final MealService mealService;
    private final MemberRepository memberRepository;
    private final MealInventoryRepository mealInventoryRepository;
    private final CategoryRepository categoryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createMeal(@RequestBody CreateMealRequest request) {
        MealInventory mealInventory = mealInventoryRepository.findById(request.getMealInventoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당 음식목록은 존재하지 않습니다."));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리는 존재하지 않습니다."));

        Meal meal = Meal.builder()
                .mealInventory(mealInventory)
                .category(category)
                .name(request.getName())
                .price(request.getPrice()).build();

        mealService.createMeal(meal);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<MealDto> getAllMeals(@RequestParam(name = "memberId") Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다."));

        return mealService.findAllByMember(member);
    }

}
