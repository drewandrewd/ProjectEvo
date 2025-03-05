package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        simpleDateFormat.setLenient(false);
        try {
            System.out.println("Введите дату в формате dd.MM.yyyy: ");
            Date firstDate = simpleDateFormat.parse(scanner.nextLine());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(firstDate);
            calendar.add(Calendar.DAY_OF_MONTH, 45);
            System.out.println("Дата после увеличения на 45 дней: " + simpleDateFormat.format(calendar.getTime()));
            calendar.setTime(firstDate);
            calendar.set(Calendar.DAY_OF_YEAR, 1);
            System.out.println("Дата после сдвига на начало года: " + simpleDateFormat.format(calendar.getTime()));
            Date tenWorkingDaysLater = addWorkingDays(firstDate, 10);
            System.out.println("Дата после увеличения на 10 рабочих дней: " + simpleDateFormat.format(tenWorkingDaysLater));
            System.out.println("Введите вторую дату в формате dd.MM.yyyy: ");
            Date secondDate = simpleDateFormat.parse(scanner.nextLine());
            int workingDaysBetween = countWorkingDaysBetween(firstDate, secondDate);
            System.out.println("Количество рабочих дней между введенными датами: " + workingDaysBetween);
        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат даты. Введите дату в формате dd.MM.yyyy.");
        }
    }

    public static Date addWorkingDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int addedDays = 0;
        while (addedDays < days) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                addedDays++;
            }
        }
        return calendar.getTime();
    }

    public static int countWorkingDaysBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int workDays = 0;
        if (start.after(end)) {
            Calendar temp = start;
            start = end;
            end = temp;
        }

        while (start.before(end)) {
            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workDays++;
            }
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        return workDays;
    }
}