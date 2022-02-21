import coffee_machine.CoffeeMachine;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int coffee, water, milk;

        if (args.length != 3) {
            printStartupNumberError();
            return;
        }

        System.out.println("Hello Peter");

        try {
            coffee = Integer.parseInt(args[0]);
            water = Integer.parseInt(args[1]);
            milk = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
            printNumberError();
            return;
        }
        if (coffee < 0 || water < 0 || milk < 0) {
            printStartupNumberError();
            return;
        }

        if (!checkIngredientValue(coffee) && checkIngredientValue(water) && checkIngredientValue(milk)) {
            printNumberError();
        } else {
            CoffeeMachine coffeeMachine = new CoffeeMachine(coffee, water, milk);
            Scanner sc = new Scanner(System.in);

            while (true) {
                String command = sc.nextLine();
                if (command.trim().equals("turn off")) {
                    System.out.println("Bye! Come to us again");
                    return;
                }

                String[] partsCommand = command.split(" ");
                if (partsCommand.length != 2) {
                    System.out.println("Command error");
                    continue;
                }

                if (checkStringToInt(partsCommand[1])) {
                    int n = stringToInt(partsCommand[1]);
                    if (!checkIngredientValue(n)) {
                        printNumberError();
                        continue;
                    }

                    String result = coffeeMachine.execute(partsCommand[0], n);
                    System.out.println(result);
                } else {
                    printNumberError();
                    continue;
                }
            }
        }
    }

    private static void printNumberError() {
        System.out.println("Number entry error");
    }

    private static void printStartupNumberError() {
        System.out.println("Error. Pass the correct parameters of the coffee machine to the program at startup");
    }

    private static boolean checkIngredientValue(int n) {
        return n >= 0;
    }

    private static boolean checkStringToInt(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static int stringToInt(String n) {
        int result = 0;

        try {
            result = Integer.parseInt(n);
        } catch (NumberFormatException ex) {
        }

        return result;
    }
}