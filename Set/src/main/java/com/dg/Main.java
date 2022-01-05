package com.dg;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        List<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("Set\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        List<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("Set\\a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
