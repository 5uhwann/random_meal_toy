package toy.random_meal.category.sevice;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toy.random_meal.category.controller.dto.CategoryDto;
import toy.random_meal.category.entity.Category;
import toy.random_meal.member.entity.Member;
import toy.random_meal.member.entity.UserId;
import toy.random_meal.member.repository.MemberRepository;

@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 카테고리조회() {
        //given
        Member member = createMember();

        createCategory(member, "testCategoryA");
        createCategory(member, "testCategoryB");

        //when
        List<CategoryDto> foundCategories = categoryService.findByMemberId(member.getId());

        //then
        assertThat(foundCategories.isEmpty()).isFalse();

    }

    private Member createMember() {
        Member member = Member.builder()
                .name("5uhwann")
                .userId(UserId.from("testtest"))
                .password("1234").build();

        memberRepository.save(member);
        return member;
    }

    private void createCategory(Member member, String name) {
        Category categoryA = Category.of(member, name);
        categoryService.createCategory(categoryA);
    }

}
