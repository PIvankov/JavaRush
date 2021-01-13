package level_19.bobr.t9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(name));
        String s;
        int key = 0;
        StringBuilder builder = new StringBuilder();

        while ((s = reader.readLine()) != null) {
            String[] arr = s.split(" ");

            for (String sArr : arr) {
               try {
                   key = Integer.parseInt(sArr);
                   if (map.containsKey(key)) builder.append(map.get(key)).append(" ");
                   else builder.append(sArr).append(" ");
               } catch (NumberFormatException e) {
                   builder.append(sArr).append(" ");
               }
            }
            builder.append("\n");
        }
        String finalStr = builder.toString().replaceAll(" \n", "\n");
        System.out.println(finalStr.substring(0, finalStr.length() - 1));
        reader.close();
    }
}