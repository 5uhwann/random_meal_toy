package toy.random_meal.web.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.random_meal.domain.mealdomain.meal.Meal;
import toy.random_meal.domain.mealdomain.meal.MealRepository;
import toy.random_meal.domain.mealdomain.randomMeal.RandomMealService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealRepository mealRepository;
    private final RandomMealService randomMealService;

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

    @GetMapping("/{mealId}/edit")
    public String editForm(@PathVariable long mealId, Model model) {
        Meal meal = mealRepository.findById(mealId);
        model.addAttribute("meal", meal);
        return "/meal/editForm";
    }

    @GetMapping("/add")
    public String addForm() {
        return "/meal/addForm";
    }

    @PostMapping("/meals")
    public String select(Model model) {
        Meal selectedMeal = randomMealService.selectMeal();
        model.addAttribute("selectedMeal", selectedMeal);
        return "redirect:/meal/randomMeal";
    }
    @PostConstruct
    public void init() {
        mealRepository.save(new Meal("돈까스", 10000, 500));
        mealRepository.save(new Meal("파스타", 11000, 450));
        mealRepository.save(new Meal("국밥", 8000, 600));
        mealRepository.save(new Meal("삼겸살", 20000, 800));
        mealRepository.save(new Meal("집밥", 4000, 500));
    }
}
