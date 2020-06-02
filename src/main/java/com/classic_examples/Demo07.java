package com.classic_examples;

/**
 * Created by root on 2019/11/7.
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */


public class Demo07 {


//    输入：1->2->5, 1->3->4
//    输出：1->1->2->3->4->4
    //递归法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res =  new ListNode(-1);;
        ListNode cour = res;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val) {
                cour.next = l1;
                l1 = l1.next;
            } else {
                cour.next = l2;
                l2 = l2.next;
            }
            cour = cour.next;
        }
        cour.next = l1 == null ? l2 : l1;
        return res.next;
    }


    public static ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsTwo(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsTwo(l1, l2.next);
            return l2;
        }
    }



    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        a.next = c;
        a.next.next = f;
        b.next = d;
        b.next.next = e;


//        ListNode res = mergeTwoLists(a, b);
        ListNode res = mergeTwoListsTwo(a, b);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}