import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //проверка задания 1
        findMinMax(Stream.of(3, 4, 2, 1, 0, 4, 9), Comparator.comparingInt(Integer::intValue), (min, max) -> System.out.println("Min: " + min + " Max: " + max));
        System.out.println();

        //проверка задания 2
        printCountOfEven(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    //задание 1
    public static<T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> tmpList = stream
                .sorted(order)
                .collect(Collectors.toList());
        T min = Optional.ofNullable(tmpList.get(0)).orElse(null);
        T max = Optional.ofNullable(tmpList.get(tmpList.size()-1)).orElse(null);
        tmpList.clear();
        minMaxConsumer.accept(min, max);
    }

    //Задание 2 - вывод четных чисел из потока в консоль
    public static void printCountOfEven(List<Integer> list) {
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }
}