package com.lukoseviciute.programming.util;

import util.CompareAll;
import util.PrintDifferences;

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

