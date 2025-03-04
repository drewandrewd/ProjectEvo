package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите 3 числа:");
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        dividerFive(Map.of("a", a, "b", b, "c", c));

        System.out.printf("Результат целочисленного деления a на b: %d\n", a / b);
        System.out.printf("Результат деления a на b: %f\n", (double) a / b);
        System.out.printf("Результат деления a на b с округлением в большую сторону: %d\n", (int)  Math.ceil((double) a / b));
        System.out.printf("Результат деления a на b с округлением в меньшую сторону: %d\n", (int) Math.floor((double) a / b));
        System.out.printf("Результат деления a на b с математическим округлением: %d\n", Math.round((double) a / b));
        System.out.printf("Остаток от деления b на c: %d\n", b % c);
        System.out.printf("Наименьшее значение из a и b: %d\n", Math.min(a, b));
        System.out.printf("Наибольшее значение из b и c: %d\n", Math.max(b, c));
    }

    public static void dividerFive(Map<String, Integer> map) {
        boolean isDividing = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 5 == 0) {
                System.out.printf("%s=%d\n", entry.getKey(), entry.getValue());
                isDividing = true;
            }
        }
        if (!isDividing) {
            System.out.println("нет значений, кратных 5");
        }
    }
}