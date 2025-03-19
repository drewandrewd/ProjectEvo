package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число a");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите число b");
        double b = Double.parseDouble(scanner.nextLine());

        Calculator calculator = new Calculator(new Adder());
        System.out.printf("Результат сложения a и b: %.1f\n", calculator.calc(a, b));

        calculator = new Calculator(new Substractor());
        System.out.printf("Результат вычитания a и b: %.1f\n", calculator.calc(a, b));

        calculator = new Calculator(new Multiplier());
        System.out.printf("Результат умножения a и b: %.1f\n", calculator.calc(a, b));

        calculator = new Calculator(new Divider());
        System.out.printf("Результат деления a и b: %.1f\n", calculator.calc(a, b));
    }
}