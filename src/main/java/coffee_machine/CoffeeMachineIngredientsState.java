package coffee_machine;

import utils.MyInteger;

public class CoffeeMachineIngredientsState {
    public MyInteger water, milk, coffee;

    public CoffeeMachineIngredientsState(int water, int coffee, int milk) {
        this.water = new MyInteger(water);
        this.milk = new MyInteger(milk);
        this.coffee = new MyInteger(coffee);
    }

    public String toString() {
        return this.coffee.v + " "
                + this.water.v + " "
                + this.milk.v;
    }
}
