package com.classic_examples;


/**
 * 翻转列表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Demo14 {

    //方法一：迭代
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prep = null;
        while (current != null){
            ListNode nextTemp = current.next;
            current.next = prep;
            prep = current;
            current = nextTemp;
        }
        return prep;
    }
    //方法二：递归
    //递归的意思：我子节点下的所有节点都已经反转好了，现在就剩我和我的子节点 没有完成最后的反转了，所以反转一下我和我的子节点。
    public static ListNode reverseListTwo(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListTwo(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }



    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        //ListNode res = reverseList(n1);
        ListNode res = reverseListTwo(n1);
        System.out.println(res);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
