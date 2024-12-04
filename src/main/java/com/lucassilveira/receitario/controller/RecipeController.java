package com.lucassilveira.receitario.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.lucassilveira.receitario.model.Dish;
import com.lucassilveira.receitario.model.DishCategory;
import com.lucassilveira.receitario.model.Employee;
import com.lucassilveira.receitario.model.Ingredient;
import com.lucassilveira.receitario.model.Measure;
import com.lucassilveira.receitario.model.Recipe;
import com.lucassilveira.receitario.model.RecipeMedia;
import com.lucassilveira.receitario.repository.DishCategoryRepository;
import com.lucassilveira.receitario.repository.DishRepository;
import com.lucassilveira.receitario.repository.IngredientRepository;
import com.lucassilveira.receitario.repository.MeasureRepository;
import com.lucassilveira.receitario.repository.RecipeMediaRepository;
import com.lucassilveira.receitario.repository.RecipeRepository;
import com.lucassilveira.receitario.service.ChefService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishCategoryRepository dishCategoryRepository;

    @Autowired
    private RecipeMediaRepository recipeMediaRepository;

    @Autowired
    private ChefService chefService; // Um serviço para obter o cozinheiro logado

    // COZINHEIRO

    @GetMapping("/chef/recipes")
    public String showRecipesList(Model model) {
        // Obtém o chef logado
        Employee chefEmployee = chefService.getLoggedInChef();

        if (chefEmployee == null) {
            // Caso o chef não esteja logado, você pode redirecionar para uma página de login
            return "redirect:/login";
        }
        
        // Obtém todos as receitas do banco de dados
        List<Recipe> recipes = recipeRepository.findByChefEmployee(chefEmployee);

        if (recipes.isEmpty()) {
            model.addAttribute("message", "Você ainda não possui receitas.");        
        } else {
            // Adiciona a lista de receitas ao modelo
            model.addAttribute("recipes", recipes);
        }
        
        // Retorna o nome da página HTML (view) que vai exibir a lista de receitas
        return "chef/recipes";
    }
    
    @GetMapping("/chef/new-recipe")
    public String recipeForm(Model model) {
        List<Measure> measures = measureRepository.findAll();
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<DishCategory> dishCategories = dishCategoryRepository.findAll();

        model.addAttribute("measures", measures);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("dishCategories", dishCategories);

        return "chef/new-recipe";
    }

    @PostMapping("/chef/new-recipe")
    public String createRecipe(@PathVariable("id") Long id, Model model) {
        
        System.out.println("Receita: " + recipe);

        Employee chefEmployee = chefService.getLoggedInChef();

        if (chefEmployee == null) {
            throw new IllegalArgumentException("Chef não logado!");
        }

        // Associa o chef à receita
        recipe.setChefEmployee(chefEmployee);

        // Salvar a receita
        recipeRepository.save(recipe);

        // Salvar os ingredientes associados à receita
        for(int i = 0; i < ingredientIds.size(); i++){
            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientIds.get(i));
            Optional<Measure> optionalMeasure = measureRepository.findById(measureIds.get(i));

            if (optionalIngredient.isPresent() && optionalMeasure.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();
                Measure measure = optionalMeasure.get();
                double quantity = quantities.get(i);

                Dish dish = new Dish();
                dish.setRecipe(recipe);
                dish.setIngredient(ingredient);
                dish.setMeasure(measure);
                dish.setQty(quantity);

                dishRepository.save(dish);
            } else {
                System.out.println("Ingredient or Measure not found for IDs: " + ingredientIds.get(i) + ", " + measureIds.get(i));
            }
        }

         // Se existirem arquivos de mídia, salva-os
         if (mediaFiles != null && mediaFiles.length > 0) {
            for (MultipartFile file : mediaFiles) {
                try {
                    RecipeMedia media = new RecipeMedia();
                    media.setRecipe(recipe);
                    media.setMedia(file.getBytes());
                    recipeMediaRepository.save(media);
                } catch (IOException e) {
                    e.printStackTrace();
                    // Gerenciar erros de I/O
                    model.addAttribute("error", "Erro ao salvar arquivos de mídia.");
                    return "chef/new-recipe";
                }
            }
        }

        return "redirect:/chef/recipes?success";
    }

    @GetMapping("/chef/edit-recipe/{id}")
    public String editRecipe(@PathVariable("id") Integer id, Model model) {
        // Obtém o chef logado
        Employee chefEmployee = chefService.getLoggedInChef();

        if (chefEmployee == null) {
            // Caso o chef não esteja logado, você pode redirecionar para uma página de login
            return "redirect:/login";
        }

        // Busca a receita pelo ID e verifica se ela pertence ao chef logado
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            // Verifica se a receita pertence ao chef logado
            if (!recipe.getChefEmployee().equals(chefEmployee)) {
                // Se o chef não for o proprietário da receita, redireciona
                return "redirect:/chef/recipes";
            }
            
            // Adiciona a receita ao modelo para ser exibida no formulário de edição
            model.addAttribute("recipe", recipe);
            
            // Carrega os dados necessários para o formulário (medidas, ingredientes, categorias)
            List<Measure> measures = measureRepository.findAll();
            List<Ingredient> ingredients = ingredientRepository.findAll();
            List<DishCategory> dishCategories = dishCategoryRepository.findAll();

            model.addAttribute("measures", measures);
            model.addAttribute("ingredients", ingredients);
            model.addAttribute("dishCategories", dishCategories);

            // Retorna a página de edição
            return "chef/edit-recipe";
        } else {
            // Caso a receita não seja encontrada
            model.addAttribute("message", "Receita não encontrada.");
            return "redirect:/chef/recipes";
        }
    }

    @PostMapping("/chef/edit-recipe/{id}")
    public String updateRecipe(@PathVariable("id") Integer id, 
                                @ModelAttribute Recipe recipe,
                                @RequestParam List<Integer> ingredientIds,
                                @RequestParam List<Integer> measureIds,
                                @RequestParam List<Double> quantities,
                                @RequestParam("file") MultipartFile[] mediaFiles,
                                Model model) {

        // Obtém o chef logado
        Employee chefEmployee = chefService.getLoggedInChef();

        if (chefEmployee == null) {
            // Caso o chef não esteja logado, você pode redirecionar para uma página de login
            return "redirect:/login";
        }

        // Busca a receita pelo ID
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (!optionalRecipe.isPresent()) {
            model.addAttribute("message", "Receita não encontrada.");
            return "redirect:/chef/recipes";
        }

        Recipe existingRecipe = optionalRecipe.get();

        // Verifica se a receita pertence ao chef logado
        if (!existingRecipe.getChefEmployee().equals(chefEmployee)) {
            // Se o chef não for o proprietário da receita, redireciona
            return "redirect:/chef/recipes";
        }

        // Atualiza os dados da receita com as informações recebidas no formulário
        existingRecipe.setName(recipe.getName());
        existingRecipe.setDishCategory(recipe.getDishCategory());
        // Continue com outros campos que precisam ser atualizados

        // Salva as alterações da receita
        recipeRepository.save(existingRecipe);

        // Atualiza os ingredientes associados
        // Limpa os ingredientes antigos, se necessário
        dishRepository.deleteByRecipe(existingRecipe);
        
        // Salva os novos ingredientes associados
        for (int i = 0; i < ingredientIds.size(); i++) {
            Optional<Ingredient> optionalIngredient = ingredientRepository.findById(ingredientIds.get(i));
            Optional<Measure> optionalMeasure = measureRepository.findById(measureIds.get(i));

            if (optionalIngredient.isPresent() && optionalMeasure.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();
                Measure measure = optionalMeasure.get();
                double quantity = quantities.get(i);

                Dish dish = new Dish();
                dish.setRecipe(existingRecipe);
                dish.setIngredient(ingredient);
                dish.setMeasure(measure);
                dish.setQty(quantity);

                dishRepository.save(dish);
            }
        }

        // Adiciona os novos arquivos de mídia, se houver
        if (mediaFiles != null && mediaFiles.length > 0) {
            for (MultipartFile file : mediaFiles) {
                try {
                    RecipeMedia media = new RecipeMedia();
                    media.setRecipe(existingRecipe);
                    media.setMedia(file.getBytes());
                    recipeMediaRepository.save(media);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Redireciona para a lista de receitas com uma mensagem de sucesso
        return "redirect:/chef/recipes?success";
    }


}
