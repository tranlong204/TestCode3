package MockInterview.collectionsTest;

/*
Design a class:
1. Inserting a value (no duplicates)
2. Removing a value
3. GetRandom a value that is already inserted (with equal probability)
 */

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        CollectionsTest test = new CollectionsTest();
        test.insert(3);
        test.insert(5);
        test.insert(3);
        test.insert(4);

        test.print();

        System.out.println("==========================");
        test.delete(3);

        test.print();

        System.out.println("Random value: " + test.getRandom());
    }

    List<Integer> values = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public void insert(int value) {
        if (map.containsKey(value)) {
            return;
        }
        values.add(value);
        map.put(value, this.values.size() - 1);
    }

    public void delete(int value) {
        if (!map.containsKey(value)) {
            return;
        }

        //swapping last value and the value that we want to remove
        int index = map.get(value);
        int lastValue = this.values.get(values.size() - 1);

        values.set(values.size() - 1, value);
        values.set(index, lastValue);

        map.put(lastValue, index);

        map.remove(value);
        values.removeLast();
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(values.size());
        return values.get(index);
    }

    public void print() {
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
