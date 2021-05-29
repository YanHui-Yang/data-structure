package com.yyh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Tong
 * Date: 2021/5/29
 * Description: 手写二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {
        if (this.root == null) {
            this.root = new Node(e);
            this.size++;
        } else
            add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    /*private void add(Node node, E e) {
        if (e.equals(node.e))   // 两数相等的情况
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) { //e比node.e小，放到左子树
            node.left = new Node(e);
            this.size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) { //e比node.e大，放到右子树
            node.right = new Node(e);
            this.size++;
            return;
        }

        // 递归调用
        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);
    }*/

    // 二分搜索树代码优化
    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {
        if (node == null) {
            this.size++;
            return new Node(e);
        }

        // 如果插入元素比树的元素小，则放到左边
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
            // 如果插入元素比树的元素大，则放到右边
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(this.root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        // 如果匹配，return true
        if (e.compareTo(node.e) == 0)
            return true;
            // 继续递归去比较
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
//        if (node == null)
//            return;
        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 二分搜索树的非递归前序遍历 = 深度优先遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        // 根节点压入栈
        stack.push(root);
        // 如果栈不为空，执行后续操作
        while (!stack.isEmpty()) {
            // 先把父亲节点弹出，打印
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 先把右子节点压入栈，再压左子节点
            // 栈先进后出，所以下次while循环弹出的是左子节点再到右子节点
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 二分搜索树的层序遍历 = 广度优先遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        // 先存根节点进队列
        queue.add(root);
        while (!queue.isEmpty()) {
            // 打印当前的根子节点
            Node cur = queue.remove();
            System.out.println(cur.e);

            // 使用队列先进先出的性质，先存左子节点，再存右子节点
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();

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
