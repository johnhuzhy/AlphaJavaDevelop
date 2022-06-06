package com.streamList;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestForStream {
    private static final List<String> ls = new ArrayList<>(Arrays.asList("chocolate", "maroon", "cheesecake", "pudding", "cookie", "pancake"));

    private static List<Product> ld = createPds();

    public static void main(String[] args) {
        Map<String, Integer> ms = ls.stream().collect(Collectors.toMap(s -> s, String::length));
        ms.forEach((k, v) -> System.out.println(k + ":" + v));

        ls.stream().filter(s -> s.length() < 8).forEach(System.out::println);
        // filter
        List<Product> ld0 = ld.stream().filter(p -> p.getType() == 0).toList();
        ld0.forEach(p -> System.out.println("id:" + p.getId() + " tp:" + p.getType() + " nm:" + p.getName() + " pr:" + p.getPrice()));
        // sum
        BigDecimal sum1 = ld.stream()
                .filter(p -> p.getId() > 5 && p.getType() == 0)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum1);
        // group by
        Map<Object, BigDecimal> md = ld.stream()
                .filter(p -> p.getType() != -1)
                .collect(Collectors.groupingBy(Product::getType,
                        Collectors.reducing(BigDecimal.ZERO, Product::getPrice, BigDecimal::add)));
        md.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static List<Product> createPds() {
        Product p1 = new Product(2);
        Product p2 = new Product(3, 0, "P2", new BigDecimal("15.9"));
        Product p3 = new Product(4);
        Product p4 = new Product(5, 1, "P4", new BigDecimal("19.6"));
        Product p5 = new Product(6);
        Product p6 = new Product(7, 0, "P6", new BigDecimal("22.8"));
        Product p7 = new Product(8);
        Product p8 = new Product(9, 1, "P8", new BigDecimal("35.0"));
        Product p9 = new Product(10, 0, "P10", new BigDecimal("8.8"));
        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }
}
