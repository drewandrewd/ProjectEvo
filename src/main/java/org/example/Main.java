package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя первого пользователя");
        String nameOfUserOne =  scanner.nextLine();
        System.out.println("Введите возраст первого пользователя");
        int ageOfUserOne = Integer.parseInt(scanner.nextLine());
        User userOne = new User(nameOfUserOne, ageOfUserOne);

        System.out.println("Введите имя второго пользователя");
        String nameOfUserTwo = scanner.nextLine();
        System.out.println("Введите возраст второго пользователя");
        int ageOfUserTwo = Integer.parseInt(scanner.nextLine());
        User userTwo = new User(nameOfUserTwo, ageOfUserTwo);

        if (userOne.getAge() < userTwo.getAge()) {
            System.out.println(userOne);
        } else if (userOne.getAge() > userTwo.getAge()) {
            System.out.println(userTwo);
        }
    }
}