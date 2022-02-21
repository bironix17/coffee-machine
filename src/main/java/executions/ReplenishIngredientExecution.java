package executions;

import coffee_machine.CoffeeMachineIngredientsState;
import utils.MyInteger;

public class ReplenishIngredientExecution extends IExecution {
    public MyInteger ingredient;
    CoffeeMachineIngredientsState state;

    public ReplenishIngredientExecution(String name, MyInteger value, CoffeeMachineIngredientsState state) {
        this.name = name;
        this.ingredient = value;
        this.state = state;
    }

    public String execute(int n) {
        ingredient.v += n;
        return this.state.toString();
    }
}
