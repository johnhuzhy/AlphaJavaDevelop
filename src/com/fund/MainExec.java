package com.fund;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainExec {
    public static void main(String[] args) {
        List<FundInfo> fundList = fundInfoInitial();

        var sums = fundList.stream().collect(Collectors.groupingBy(compositeKey, Collectors.summingInt(FundInfo::getCount)));
        sums.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).forEach(System.out::println);

        var keys = fundList.stream().collect(Collectors.groupingBy(compositeKey2));
        keys.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).forEach(System.out::println);

        Map<FundKey, List<FundInfo>> grpByComplexKeys = fundList.stream().collect(
                Collectors.groupingBy(fi -> new FundKey(fi.getFund(), fi.getIss())));
        grpByComplexKeys.forEach((k, v) -> {
            System.out.println(k.fund);
            System.out.println(k.iss);
        });
    }

    static  Function<FundInfo, String> compositeKey = prd -> {
        StringBuilder sb = new StringBuilder();
        sb.append(prd.getFund()).append("-").append(prd.getIss()).append("-").append(prd.getDate().toString());
        return sb.toString();
    };

    static  Function<FundInfo, String> compositeKey2 = prd -> {
        StringBuilder sb = new StringBuilder();
        sb.append(prd.getFund()).append("-").append(prd.getIss());
        return sb.toString();
    };

    public static class FundKey {
        private final String fund;
        private final String iss;

        public FundKey(String fund, String iss) {
            this.fund = fund;
            this.iss = iss;
        }
    }

    public static List<FundInfo> fundInfoInitial(){
        List<FundInfo> fundInfoList = new ArrayList<>();

        FundInfo fundA1 = new FundInfo();
        fundA1.setFund("fundA");
        fundA1.setIss("IssA");
        fundA1.setDate(new Date(2022, Calendar.MAY,1));
        fundA1.setCount(1000);
        fundInfoList.add(fundA1);

        FundInfo fundA2 = new FundInfo();
        fundA2.setFund("fundA");
        fundA2.setIss("IssA");
        fundA2.setDate(new Date(2022, Calendar.MAY,1));
        fundA2.setCount(3000);
        fundInfoList.add(fundA2);

        FundInfo fundA3 = new FundInfo();
        fundA3.setFund("fundA");
        fundA3.setIss("IssA");
        fundA3.setDate(new Date(2022, Calendar.MAY,2));
        fundA3.setCount(3000);
        fundInfoList.add(fundA3);

        FundInfo fundA4 = new FundInfo();
        fundA4.setFund("fundA");
        fundA4.setIss("IssA");
        fundA4.setDate(new Date(2022, Calendar.MAY,2));
        fundA4.setCount(5000);
        fundInfoList.add(fundA4);

        return fundInfoList;
    }
}
