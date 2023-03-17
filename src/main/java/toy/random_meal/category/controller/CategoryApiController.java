package toy.random_meal.category.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import toy.random_meal.category.controller.dto.CategoryDto;
import toy.random_meal.category.controller.dto.CreateCategoryRequest;
import toy.random_meal.category.entity.Category;
import toy.random_meal.category.repository.CategoryRepository;
import toy.random_meal.category.sevice.CategoryService;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryApiController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    private final MemberRepository memberRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCategory(@RequestBody CreateCategoryRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        Category category = Category.builder()
                .member(member)
                .name(request.getCategoryName()).build();

        categoryService.createCategory(category);
    }

    @GetMapping("/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getAllCategories(@PathVariable Long memberId) {
        if (memberRepository.findById(memberId).isEmpty()) {
            throw new IllegalArgumentException("해당 회원이 존재하지 않습니다.");
        }
        return categoryService.findByMemberId(memberId);
    }

    @DeleteMapping("{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 존재하지 않습니다."));

        categoryService.delete(category);
    }

}
