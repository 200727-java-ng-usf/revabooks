package com.revature.revabooks.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDriver {

    public static void main(String[] args) {
        List<String> rockColors = Arrays.asList("Red", "Blue", "Black");

        List<Geode> geodes = rockColors.stream()
                .map(color -> {
                    switch (color.toLowerCase()) {
                        case "red":
                            return new Geode("ruby", color);
                        case "blue":
                            return new Geode("sapphire", color);
                        case "black":
                            return new Geode("obsidian", color);
                        default:
                            return new Geode("agate", color);
                    }
                })
                .collect(Collectors.toList());

        geodes.forEach(System.out::println);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int sum = nums.stream().reduce(0, (subtotal, num) -> subtotal + num);
        System.out.println(sum);
    }
}
