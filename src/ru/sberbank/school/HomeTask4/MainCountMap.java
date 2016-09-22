package ru.sberbank.school.HomeTask4;

import java.util.HashMap;
import java.util.Map;

public class MainCountMap {
    public static void main(String[] args) {
        //проверка add()
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println("количество 5 : " + map.getCount(5)); // 2
        System.out.println("количество 6 : " + map.getCount(6)); // 1
        System.out.println("количество 10 : " + map.getCount(10)); // 3
        System.out.println();

        //проверка remove()
        System.out.println("удаляем 10, осталось элементов : " + map.remove(10));
        System.out.println("удалили 10 : " + map.getCount(10));
        System.out.println("удаляем 6, осталось элементов : " + map.remove(6));
        System.out.println("удалили 6 : " + map.getCount(6));
        System.out.println();

        //проверка toMap()
        Map<Integer, Integer> newMap = map.toMap();
        for (Map.Entry<Integer, Integer> entry : newMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //проверка size()
        System.out.println("количество уникальных элементов : " + map.size());
        System.out.println();

        //проверка addAll()
        CountMap<Integer> map2 = new CountMapImpl<>();
        System.out.println("добавили 10 и 12");
        map2.add(10);
        map2.add(12);
        map.addAll(map2);
        for (Map.Entry<Integer, Integer> entry : map.toMap().entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //проверка toMap(dest)
        Map<Integer, Integer> destination = new HashMap<>();
        map.toMap(destination);
        for (Map.Entry<Integer, Integer> entry : destination.entrySet()) {
            System.out.println(entry);
        }

    }
}
