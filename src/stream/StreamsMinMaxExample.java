package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {
    public static Optional<Integer> findMaxValue(List<Integer> list) {
        return list.stream().reduce((x, y) -> x < y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,2,3,1,19,33,2,3,5,6);
        Optional<Integer> op = findMaxValue(list);
        op.ifPresent(System.out::println);
    }
}
