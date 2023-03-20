package toy.random_meal.mealinventory.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.random_meal.mealinventory.controller.dto.MealInventoryDto;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.service.MemberService;

@SpringBootTest
class MealInventoryServiceImplTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MealInventoryServiceImpl mealInventoryService;

    @Test
    void 음식목록조회() {
        //given
        Member member = createMember();

        memberService.joinMember(member);

        MealInventory mealInventoryA = createMealInventory(member, "testInventoryA");

        MealInventory mealInventoryB = createMealInventory(member, "testInventoryB");

        mealInventoryService.createMealInventory(mealInventoryA);
        mealInventoryService.createMealInventory(mealInventoryB);

        //when
        List<MealInventoryDto> foundMealInventory = mealInventoryService.findAllByMember(member);

        //then
        assertThat(foundMealInventory.isEmpty()).isFalse();
    }

    @Test
    void 음식목록_이름변경() {
        //given
        Member member = createMember();
        memberService.joinMember(member);

        MealInventory mealInventory = createMealInventory(member, "testInventory");
        mealInventoryService.createMealInventory(mealInventory);

        String newName = "newTestInventory";

        //when
        MealInventoryDto mealInventoryDto = mealInventoryService.updateName(mealInventory, newName);

        //then
        assertThat(mealInventoryDto.getName()).isEqualTo(newName);
    }

    private static MealInventory createMealInventory(Member member, String inventoryName) {
        return MealInventory.builder()
                .member(member)
                .name(inventoryName).build();
    }

    private static Member createMember() {
        return Member.builder()
                .name("5uhwann")
                .userId(UserId.from("testtest"))
                .password("1234").build();
    }

}
