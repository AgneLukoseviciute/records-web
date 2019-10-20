package com.lukoseviciute.programming.util;

public class Main{

    public static void main(String[] args) {

        CompareAll comparator = new CompareAll.CompareAllBuilder()
                .csvFile("assets/records.csv")
                .jsonFile("assets/records_tweaked.json")
                .xmlFile("assets/records_tweaked.xml")
                .build();

        PrintDifferences.printDiffs(comparator.compare());
    }

}

