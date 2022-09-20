package toy.random_meal.web.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.mealdomain.meal.MealRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MealController {

    private final MealRepository mealRepository;

    @GetMapping("/meal/meals")
    public String meals(Model model) {
        List<Meal> meals = mealRepository.findAll();
        model.addAttribute("meals", meals);
        return "/meal/meals";
    }
}
