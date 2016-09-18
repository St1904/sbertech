package ru.sberbank.school;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HomeTask3 {
    public static void main(String[] args) throws IOException{

//        int count = countUniqueWords("C:\\tmp\\test.txt");
//        System.out.println(count);

//        Set<String> set = sortByLength("C:\\tmp\\test.txt");
//        Set<String> set = sortByText("C:\\tmp\\test.txt");
//        for (String s : set) {
//            System.out.println(s);
//        }

//        Map<String, Integer> map = countWords("C:\\tmp\\test.txt");
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry);
//        }

//        LinkedList<String> list = reverseLine("C:\\tmp\\test.txt");
//        for (String s : list) {
//            System.out.println(s);
//        }

        ArrayList<String> list = lineOrder("C:\\tmp\\test.txt", new int[]{2, 1});
        for (String s : list) {
            System.out.println(s);
        }

    }

    //подсчет общего количества уникальных слов
    static int countUniqueWords(String fileName) throws IOException{
        Set<String> result = new HashSet<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("\\s*(\\s|,|!|-|:|\\.|\\(|\\))\\s*");

            for (String s : words) {
                if (!s.equals(""))
                    result.add(s.toLowerCase());
            }
        }

        reader.close();
        return result.size();
    }

    //сортировка уникальных слов по длине строки
    static Set<String> sortByLength(String fileName) throws IOException {
        Set<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //это нарушает работу TreeSet
            }
        });

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("\\s*(\\s|,|!|-|:|\\.|\\(|\\))\\s*");

            for (String s : words) {
                if (!s.equals("")) {
                    result.add(s.toLowerCase());
                }
            }
        }

        reader.close();
        return result;
    }

    //сортировка уникальных слов по умолчанию
    static Set<String> sortByText(String fileName) throws IOException {
        Set<String> result = new TreeSet<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("\\s*(\\s|,|!|-|:|\\.|\\(|\\))\\s*");

            for (String s : words) {
                if (!s.equals("")) {
                    result.add(s.toLowerCase());
                }
            }
        }

        reader.close();
        return result;
    }

    //подсчет количества уникальных слов
    static Map<String, Integer> countWords(String fileName) throws IOException {
        Map<String, Integer> result = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("\\s*(\\s|,|!|-|:|\\.|\\(|\\))\\s*");

            for (String s : words) {
                if (!s.equals("")) {
                    if (result.containsKey(s)) {
                        result.put(s, result.get(s) + 1);
                    } else {
                        result.put(s, 1);
                    }
                }
            }
        }

        reader.close();
        return result;
    }

    //вывод строк в обратном порядке
    static LinkedList<String> reverseLine(String fileName) throws IOException {
        LinkedList<String> result = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            result.add(0, line);
        }

        reader.close();
        return result;
    }

/*    static class MyIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public String next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }*/

    //вывод строк по номерам, заданным пользователем
    static ArrayList<String> lineOrder(String fileName, int[] numbers) throws IOException{
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            String line = reader.readLine();
            list.add(line);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            result.add(list.get(numbers[i]));
        }

        reader.close();
        return result;
    }
}
