package com.dg;

public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private final BinarySearchTree<E> bst;

    public BinarySearchTreeSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }
}
