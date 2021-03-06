package com.yyh;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

//        System.out.println(bst);

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.preOrderNR();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}
