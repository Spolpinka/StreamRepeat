import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        printCountOfEven(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    //задание 1
    public static<T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        T min = stream.min(order).orElse(null);
        T max = stream.max(order).orElse(null);

        minMaxConsumer.accept(min, max);
    }

    //Задание 2 - вывод четных чисел из потока в консоль
    public static void printCountOfEven(List<Integer> list) {
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }
}