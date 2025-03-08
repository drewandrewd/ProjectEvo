package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            int age = Integer.parseInt(scanner.nextLine());
            User newUser = new User(name, age);
            if (map.containsKey(age)) {
                List<User> users = map.get(age);
                users.add(newUser);
                map.put(age, users);
            } else {
                map.put(age, new ArrayList<>(List.of(newUser)));
            }
        }

        System.out.println("Введите требуемый возраст");
        int age = Integer.parseInt(scanner.nextLine());
        if (map.containsKey(age)) {
            List<User> users = map.get(age);
            users.stream().forEach(curr -> System.out.println(curr));
        } else {
            System.out.printf("Пользователь с возрастом '%d' не найден", age);
        }
    }
}