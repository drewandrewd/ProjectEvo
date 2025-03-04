package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(15) + 1;
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
            }
            else {
                if (count > 1) {
                    map.put(arr[i - 1], count);
                }
                count = 1;
            }
        }

        if (count > 1) {
            map.put(arr[arr.length - 1], count);
        }

        if (!map.isEmpty()) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.printf("Число '%d' встречается %d раза\n", entry.getKey(), entry.getValue());
            }
        }
    }
}