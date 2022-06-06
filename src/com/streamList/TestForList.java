package com.streamList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestForList {
    public static void main(String[] args) {
        //List.of()は変更不可(unmodifiable) のリスト
        List<Integer> li = List.of(1, 3, 5, 7, 9);
        li.forEach(System.out::println);

        //Arrays.asList()は変更可能
        List<String> ls = Arrays.asList("2", "3", "4");
        ls.set(0, "3");
        ls.forEach(System.out::println);
        List<String> ls2 = List.of("2", "3", "4");
        // ls2.set(0,"3");  //実行エラー
        ls2.forEach(System.out::println);

        // List.of() nullを許容しない
        //List<String> ls3 = List.of("1",null); //実行エラー

        List<String> ls4 = Arrays.asList("1", "s3", "2", "d000");
        //アルファベット順でソート
        ls4.sort(String::compareToIgnoreCase);
        ls4.forEach(System.out::println);
        //文字列長でソート
        ls4.sort(Comparator.comparingInt(String::length));
        ls4.forEach(System.out::println);
    }
}
