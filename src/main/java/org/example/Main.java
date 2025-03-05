package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String line = scanner.nextLine();
        System.out.println("Введите подстроку");
        String subLine = scanner.nextLine();
        countSubstring(line, subLine);

        System.out.println("Введите строку");
        String newLine = scanner.nextLine();
        replaceLine(newLine);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String dateLine = scanner.nextLine();
        reformDate(dateLine);
    }
    
    public static void countSubstring(String line, String subLine) {
        int count = 0;
        for (int i = 0; i < line.length(); i ++) {
            int subIndex = i + subLine.length();
            if (subIndex <= line.length() && line.substring(i, subIndex).equals(subLine)) {
                count++;
            }
        }
        System.out.printf("Подстрока %s встречается %d раза\n", subLine, count);
    }

    public static void replaceLine(String line) {
        String replacer = "вырезано цензурой";
        String newLine = line.replace("кака", replacer);
        newLine = newLine.replace("бяка", replacer);
        System.out.println(newLine);
    }

    public static void reformDate(String line) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(line);
            System.out.println(newFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}