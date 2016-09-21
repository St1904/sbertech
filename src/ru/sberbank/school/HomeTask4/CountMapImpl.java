package ru.sberbank.school.HomeTask4;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        if (map.containsKey(o))
            return map.get(o);
        else return 0;
    }

    @Override
    public int remove(T o) {
        if (map.get(o) == 1) {
            map.remove(o);
            return 1;
        } else {
            map.put(o, map.get(o) - 1);
            return map.get(o) + 1;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> entry : source.toMap().entrySet()) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            destination.put(entry.getKey(), entry.getValue());
        }
    }
}
