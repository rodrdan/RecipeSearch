
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.start(scanner);
    }
}
