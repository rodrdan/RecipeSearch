import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final String name;
    private final int cookingTime;
    private final ArrayList<String> ingredientList;
    public Recipe(String name, int cookingTime, ArrayList<String> ingredientList) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredientList = ingredientList;
    }
    public String getName() {
        return this.name;
    }
    public int getCookingTime() {
        return this.cookingTime;
    }
    public List<String> getIngredientList() {
        return this.ingredientList;
    }
    public String toString() {
        return this.name + ", cooking time: " + cookingTime;
    }


}
