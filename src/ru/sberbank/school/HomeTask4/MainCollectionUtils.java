package ru.sberbank.school.HomeTask4;

import java.util.Arrays;
import java.util.List;

public class MainCollectionUtils {
    public static void main(String[] args) {
        System.out.println("Создание коллекции");
        List<Integer> list = CollectionUtils.newArrayList();
        list.add(1);
        System.out.println(list.get(0));
        System.out.println();

        System.out.println("Слияние двух коллекций");
        List<Integer> list1 = CollectionUtils.newArrayList();
        list1.add(3);
        CollectionUtils.addAll(list1, list);
        for (Integer x : list) {
            System.out.println(x);
        }
        System.out.println();

        System.out.println("Добавление элементов, нахождение индекса по элементу");
        CollectionUtils.add(list, 5);
        CollectionUtils.add(list, 7);
        System.out.println(CollectionUtils.indexOf(list, 5));
        System.out.println(CollectionUtils.indexOf(list, 7));
        System.out.println();

        System.out.println("TrimToSize aka Limit");
        List<Integer> list2 = CollectionUtils.limit(list, 2);
        for (Integer x : list2) {
            System.out.println(x);
        }
        System.out.println();

        System.out.println("Удаление нескольких объектов");
        list2.add(5);
        list2.add(7);
        list2.add(9);
        CollectionUtils.removeAll(list2, Arrays.asList(1, 2, 3, 9));
        for (Integer x : list2) {
            System.out.println(x);
        }
        System.out.println();

        System.out.println("Проверка ContainsAll");
        System.out.println(CollectionUtils.containsAll(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 4, 5)));
        System.out.println(CollectionUtils.containsAll(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 4, 6)));
        System.out.println();

        System.out.println("Проверка ContainsAny");
        System.out.println(CollectionUtils.containsAny(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8)));
        System.out.println(CollectionUtils.containsAny(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(2, 4, 6)));
        System.out.println();

        System.out.println("Проверка range");
        System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6)); // вернет {3,4,5,6}
    }
}
