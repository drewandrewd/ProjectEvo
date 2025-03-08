package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            int age = Integer.parseInt(scanner.nextLine());
            users.add(new User(name, age));
        }

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        users.stream().forEach(curr -> System.out.println(curr));
    }
}