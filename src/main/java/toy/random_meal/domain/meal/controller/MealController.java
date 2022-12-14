package toy.random_meal.domain.meal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toy.random_meal.domain.meal.service.ManageMealService;
import toy.random_meal.domain.meal.entity.Meal;
import toy.random_meal.domain.meal.repository.MealRepository;
import toy.random_meal.domain.meal.service.RandomMealService;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/meal")
@RequiredArgsConstructor
public class MealController {

    private final MealRepository mealRepository;
    private final RandomMealService randomMealService;
    private final ManageMealService manageMealService;

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

    @PostMapping("/add")
    public String add(@ModelAttribute Meal meal) {
        manageMealService.addMeal(meal);
        return "redirect:/meal/meals";
    }

    @GetMapping("/{mealId}/edit")
    public String editForm(@PathVariable long mealId, Model model) {
        Meal meal = mealRepository.findById(mealId);
        model.addAttribute("meal", meal);
        return "/meal/editForm";
    }

    @PostMapping("/{mealId}/edit")
    public String edit(@PathVariable Long mealId, @ModelAttribute Meal updateParam) {
        manageMealService.editMeal(mealId, updateParam);
        return "redirect:/meal/meals";
    }

    @PostMapping("{mealId}/edit/delete")
    public String delete(@PathVariable Long mealId) {
        manageMealService.deleteMeal(mealId);
        return "redirect:/meal/meals";
    }

    @GetMapping("/select")
    public String randomMeal(Model model) {
        Meal selectedMeal = mealRepository.getSelectedMeal();
        model.addAttribute("selectedMeal", selectedMeal);
        return "/meal/randomMeal";
    }

    @PostMapping("/select")
    public String select(Model model) {
        randomMealService.selectMeal();
        return "redirect:/meal/select";
    }

}
