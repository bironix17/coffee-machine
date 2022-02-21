package executions;

import coffee_machine.CoffeeMachineIngredientsState;
import exceptions.OutOfIngredient;

public class CreateDrinkExecution extends IExecution {
    private float fractionCoffee, fractionWater, fractionMilk;
    private CoffeeMachineIngredientsState state;

    public CreateDrinkExecution(String name, byte percentCoffee, byte percentWater, byte percentMilk, CoffeeMachineIngredientsState state) {
        this.name = name;
        this.fractionCoffee = (float) percentCoffee / 100;
        this.fractionWater = (float) percentWater / 100;
        this.fractionMilk = (float) percentMilk / 100;
        this.state = state;
    }

    public String execute(int n) {
        if (!this.checkInputValue(n)) {
            return "the value of n must be at least 10";
        } else {
            try {
                this.validateExecution(n);
            } catch (OutOfIngredient ex) {
                return ex.toString();
            }

            state.coffee.v = (int) (state.coffee.v - n * fractionCoffee);
            state.water.v = (int) (state.water.v - n * fractionWater);
            state.milk.v = (int) (state.milk.v - n * fractionMilk);
            return state.toString();
        }
    }

    private boolean checkInputValue(int n) {
        return n >= 10;
    }

    private void validateExecution(int n) throws OutOfIngredient {
        if (this.state.coffee.v - n * this.fractionCoffee < 0) {
            throw new OutOfIngredient("coffee");

        } else if (this.state.water.v - n * this.fractionWater < 0) {
            throw new OutOfIngredient("water");

        } else if (this.state.milk.v - n * this.fractionMilk < 0) {
            throw new OutOfIngredient("milk");
        }
    }
}
