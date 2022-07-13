package _14_java;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Return random subset of arbitrary size
//Probability of choosing an element = 50%
//{}, {2}, {3}, {2, 3}
//{1}, {1, 2}, {1, 3}, {1, 2, 3}
public class Example8_1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = List.of(1, 2, 3);
        Predicate<Object> flipCoin = k -> {
            return random.nextBoolean();
        };
        List<Integer> subset = list.stream().filter(flipCoin).collect(Collectors.toList());
        System.out.println(subset);
    }
}

