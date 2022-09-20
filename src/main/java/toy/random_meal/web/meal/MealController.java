package toy.random_meal.web.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.mealdomain.meal.MealRepository;

import java.util.List;

@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealRepository mealRepository;

    @GetMapping("/meals")
    public String meals(Model model) {
        List<Meal> meals = mealRepository.findAll();
        model.addAttribute("meals", meals);
        return "/meal/meals";
    }

    @GetMapping("{mealId}")
    public String meal(@PathVariable long mealId, Model model) {
        Meal meal = mealRepository.findById(mealId);
        model.addAttribute("meal", meal);
        return "/meal/meal";
    }

    @GetMapping("/add")
    public String addForm() {
        return "/meal/addForm";
    }
}
