import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeBook {
    private final List<Recipe> recipeList;
    public RecipeBook() {
        this.recipeList = new ArrayList<>();
    }
    public void start(Scanner scanner) {
        // getting the recipes file
        System.out.println("File to read: ");
        String fileName = scanner.nextLine();
        // reading the recipes
        addRecipes(fileName);
        // processing user commands
        while (true) {
            System.out.println("Commands:\n" +
                    "list - lists the recipes\n" +
                    "stop - stops the program\n" +
                    "find name - searches recipes by name\n" +
                    "find cooking time - searches recipes by cooking time\n" +
                    "find ingredient - searches recipes by ingredient");
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println();
                for (Recipe recipe : this.recipeList) {
                    System.out.println(recipe);
                }
                System.out.println();
            }
            if (command.equals("find name")) {
                System.out.println("Searched word:");
                String searchedWord = scanner.nextLine();
                findByName(searchedWord);
            }
            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int maxCookingTime = Integer.valueOf(scanner.nextLine());
                findByCookingTime(maxCookingTime);
            }
            if (command.equals("find ingredient")) {
                System.out.println("Ingredient:");
                String ingredient = scanner.nextLine();
                findByIngredient(ingredient);
            }
        }
    }
    private void addRecipes(String fileName) {
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                // getting the name on the first line
                String recipeName = reader.nextLine();
                // getting the time on the second line
                int cookingTime = Integer.valueOf(reader.nextLine());
                // getting ingredients on the rest of the lines
                ArrayList<String> ingredients = new ArrayList<>();
                while (reader.hasNext()) {
                    String ingredient = reader.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }
                    ingredients.add(ingredient);
                }
                this.recipeList.add(new Recipe(recipeName, cookingTime, ingredients));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void findByName(String name) {
        for (Recipe recipe : this.recipeList) {
            if (recipe.getName().contains(name)) {
                System.out.println(recipe);
            }
        }
    }
    private void findByCookingTime(int maxCookingTime) {
        for (Recipe recipe : this.recipeList) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }
    private void findByIngredient(String ingredient) {
        for (Recipe recipe : this.recipeList) {
            if (recipe.getIngredientList().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }

}
