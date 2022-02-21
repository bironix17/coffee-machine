package coffee_machine;

import executions.CreateDrinkExecution;
import executions.IExecution;
import executions.ReplenishIngredientExecution;

public class CoffeeMachine {
    private CoffeeMachineIngredientsState state;
    private IExecution[] executions;

    public CoffeeMachine(int water, int coffee, int milk) {
        this.state = new CoffeeMachineIngredientsState(water, coffee, milk);
        this.initExecutions();
    }

    public String execute(String command, int n) {
        String result = null;
        for (IExecution x : executions) {
            if (command.trim().equals(x.name)) {
                result = x.execute(n);
            }
        }

        if (result == null) {
            result = "command error";
        }

        return result;
    }

    private void initExecutions() {
        this.executions = new IExecution[]{
                new CreateDrinkExecution("ristretto", (byte) 50, (byte) 50, (byte) 0, this.state),
                new CreateDrinkExecution("espresso", (byte) 30, (byte) 70, (byte) 0, this.state),
                new CreateDrinkExecution("lungo", (byte) 15, (byte) 85, (byte) 0, this.state),
                new CreateDrinkExecution("cappuccino", (byte) 15, (byte) 40, (byte) 45, this.state),
                new CreateDrinkExecution("latte", (byte) 10, (byte) 30, (byte) 60, this.state),

                new ReplenishIngredientExecution("water", state.water, this.state),
                new ReplenishIngredientExecution("coffee", state.coffee, this.state),
                new ReplenishIngredientExecution("milk", state.milk, this.state),
        };
    }
}
