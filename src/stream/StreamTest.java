package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> names = List.of("apple", "banana", "cherry", "orange", "pineapple", "apache");
//        Stream<String> stream = names.stream();
////        stream.forEach(System.out::println);
//        Optional<String> resultOptional = stream.reduce((a, b) -> a + b);
//        List<String> result = resultOptional.stream().toList();
//        result.forEach(System.out::println);

        List<String> filtered = names.stream()
                .filter(s -> s.startsWith("a"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(filtered);
    }
}
