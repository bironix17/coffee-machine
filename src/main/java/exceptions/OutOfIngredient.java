package exceptions;

public class OutOfIngredient extends Exception {
    String ingredientName;

    public OutOfIngredient( String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        return "Error. Not enough ingredient - " + ingredientName;
    }
}
