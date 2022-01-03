package com.yyh;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LeetCodeProblem {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {

        // 首先考虑head节点就是待删除的元素
        // 如果头节点不为null且头节点就是待删除的元素，则删除该元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        // 如果整个链表所有的节点都是待删除的节点，此时链表为null
        if(head == null) {
            return head;
        }

        // 删除head.next的元素
        ListNode prev = head;
        while (prev.next != null) {
            // 如果相等，则删除，不相等则遍历
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}
