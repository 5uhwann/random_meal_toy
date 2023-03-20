package toy.random_meal.mealinventory.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import toy.random_meal.mealinventory.controller.dto.ChangeMealInventoryNameRequest;
import toy.random_meal.mealinventory.controller.dto.CreateMealInventoryRequest;
import toy.random_meal.mealinventory.controller.dto.MealInventoryDto;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.mealinventory.repository.MealInventoryRepository;
import toy.random_meal.mealinventory.service.MealInventoryService;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventories")
public class MealInventoryApiController {

    private final MealInventoryService mealInventoryService;
    private final MemberRepository memberRepository;
    private final MealInventoryRepository mealInventoryRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createInventory(@RequestBody CreateMealInventoryRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        MealInventory mealInventory = MealInventory.builder()
                .name(request.getMealInventoryName())
                .member(member).build();

        mealInventoryService.createMealInventory(mealInventory);
    }

    @GetMapping("{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public List<MealInventoryDto> getAllMealInventories(@PathVariable Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        return mealInventoryService.findAllByMember(member);
    }

    @PatchMapping("/{mealInventoryId}")
    @ResponseStatus(HttpStatus.OK)
    public MealInventoryDto changeMealInventoryName(
            @PathVariable Long mealInventoryId,
            @RequestBody ChangeMealInventoryNameRequest request) {
        MealInventory mealInventory = mealInventoryRepository.findById(mealInventoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 음식 목록이 존재하지 않습니다."));

        return mealInventoryService.updateName(mealInventory, request.getBeforeName(), request.getUpdateName());
    }
}
