package com.yyh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestRemoveMin {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        List<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMin test completed.");


        // test removeMax
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error!");
            }
        }
        System.out.println("removeMax test completed.");
    }
}
