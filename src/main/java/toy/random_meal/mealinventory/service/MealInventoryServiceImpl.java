package toy.random_meal.mealinventory.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.random_meal.mealinventory.controller.dto.MealInventoryDto;
import toy.random_meal.mealinventory.entity.MealInventory;
import toy.random_meal.mealinventory.repository.MealInventoryRepository;
import toy.random_meal.member.entity.Member;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MealInventoryServiceImpl implements MealInventoryService{

    private final MealInventoryRepository mealInventoryRepository;

    @Override
    @Transactional
    public Long createMealInventory(MealInventory mealInventory) {
        mealInventoryRepository.save(mealInventory);
        return mealInventory.getId();
    }

    @Override
    public List<MealInventoryDto> findAllByMember(Member member) {
        return mealInventoryRepository.findByMember(member).stream()
                .map(MealInventoryDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MealInventoryDto updateName(MealInventory mealInventory, String beforeName, String updateName) {
        validateUpdateName(beforeName, updateName);
        mealInventory.changeName(updateName);
        return MealInventoryDto.from(mealInventory);
    }

    private void validateUpdateName(String beforeName, String updateName) {
        if (beforeName.equals(updateName)) {
            throw new IllegalArgumentException("이전과 다른 이름으로 수정해야 합니다.");
        }
    }
}
