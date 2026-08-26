package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List<Integer> list) {
        return list.stream()
                .skip(3)
                .reduce((x,y) -> x+y);

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,7,8,9,10);
        Optional<Integer> op = limit(list);
        op.ifPresent(System.out::println);
    }
}
