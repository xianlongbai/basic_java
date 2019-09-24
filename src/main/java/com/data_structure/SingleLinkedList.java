package com.data_structure;

import java.util.Stack;

/**
 * Created by root on 2019/4/21.
 *
 * 单链表的实现
 */
public class SingleLinkedList {

    //内部类,定义node节点
    class Node{
        public int val;
        public Node next;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
    }

    public Node head = new Node();

    //添加节点
    public void add(int data){
        if (head.next == null){
            head.next = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    //删除节点
    public boolean deleteNode(int index){
        if (index < 0 || index > length() ){
            return false;
        }
        if (index == 1){ //删除头结点
            head = head.next;
            return true;
        }
        Node preNode = head;
        Node curNode = preNode.next;
        int i = 1;
        while (curNode!=null){
            if (index == i){
                preNode.next = curNode.next;  //指向删除节点的后一个节点
                break;
            }
            preNode = curNode;
            curNode = preNode.next;
            i++;
        }
        return true;
    }

    //插入节点

    //获取链表长度
    public int length(){
        int length = 0;
        Node temp = head;
        while (temp.next!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //获取最后一个节点
    public Node getLastNode(){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    //获取第index节点
    public Node getNodeByIndex(int index){
        if(index<1 || index>length()){//不合法的k
            return null;
        }
        Node temp = head;
        int i = 1;
        while (temp.next != null){
            temp = temp.next;
            if (index==i){
                break;
            }
            i++;
        }
        return temp;
    }

    //打印节点
    public void printLink(){
        Node curNode = head;
        while(curNode !=null){
            System.out.print(curNode.val+" ");
            curNode = curNode.next;
        }
    }

    //返回倒数第k个结点
    public Node findReverNode(int index){
        if(index<1 || index>length()){//不合法的k
            return null;
        }
        Node first = head;
        Node second = head;
        for (int i = 0; i < index - 1; i++) {
            second = second.next;
        }
        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        return first;
    }


    /**
     * 链表反转
     * 从头到尾遍历原链表，每遍历一个结点，将其摘下放在新链表的最前端。注意链表为空和只有一个结点的情况。时间复杂度为O（n）
     */
    public void reserveLink(){
        Node curNode = head;
        Node preNode = null;
        while (curNode.next != null){
            Node nextNode = curNode.next;
            curNode.next = preNode; //将current的下一个结点指向新链表的头结点
            preNode = curNode;  //将改变了指向的cruNode赋值给preNode
            curNode = nextNode;
        }
        curNode.next = preNode;
        preNode = curNode;
        head = preNode;
    }


    /**
     * 反向输出链表，三种方式：
     * 方法一、先反转链表，再输出链表，需要链表遍历两次(不介意,改变了链表的结构)
     * 方法二、把链表中的数字放入栈中再输出，需要维护额外的栈空间
     * 方法三、依据方法2中栈的思想，通过递归来实现，递归起始就是将先执行的数据压入栈中，再一次出栈（当链表很长的时候，就会导致方法调用的层级很深，有可能造成栈溢出）
     *
     */
    public void reservePrt(Node node){
        if(node != null){
            reservePrt(node.next);
            System.out.print(node.val+" ");
        }
    }

    public void reservePrt2(Node node){
        if(node != null){
            Stack<Node> stack = new Stack<Node>();  //新建一个栈
            Node current = head;
            //将链表的所有结点压栈
            while (current != null) {
                stack.push(current);  //将当前结点压栈
                current = current.next;
            }
            //将栈中的结点打印输出即可
            while (stack.size() > 0) {
                System.out.print(stack.pop().val+" ");  //出栈操作
            }
        }
    }


    /**
     * 寻找单链表的中间结点：
     * 方法一、先求出链表的长度，再遍历1/2链表长度，寻找出链表的中间结点
     * 方法二、：
     * 用两个指针遍历链表，一个快指针、一个慢指针，
     * 快指针每次向前移动2个结点，慢指针一次向前移动一个结点，
     * 当快指针移动到链表的末尾，慢指针所在的位置即为中间结点所在的位置
     */
    public Node findMiddleNode(){
        Node slowPoint = head;
        Node quickPoint = head;
        //quickPoint.next == null是链表结点个数为奇数时，快指针已经走到最后了
        //quickPoint.next.next == null是链表结点数为偶数时，快指针已经走到倒数第二个结点了
        //链表结点个数为奇数时,返回的是中间结点；链表结点个数为偶数时，返回的是中间两个结点中的前一个
        while(quickPoint != null && quickPoint.next != null){
            slowPoint = slowPoint.next;
            quickPoint = quickPoint.next.next;
        }
        return slowPoint;
    }

    /**
     * 判断链表是否有环：
     * 设置快指针和慢指针，慢指针每次走一步，快指针每次走两步
     * 当快指针与慢指针相等时，就说明该链表有环
     */
    public boolean isRinged(){
        if(head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    public Node getFirstMeet(){
        if(head == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }

    //方法：有环链表中，获取环的长度。参数node代表的是相遇的那个结点
    public int getCycleLength(){
        Node current = getFirstMeet(); //获取相遇点
        int length = 0;
        while (current != null) {
            current = current.next;
            length++;
            if (current == getFirstMeet()) {  //当current结点走到原点的时候
                return length;
            }
        }
        return length;
    }


    /**
     * 在不知道头结点的情况下删除指定结点：
     * 删除结点的重点在于找出其前结点，使其前结点的指针指向其后结点，即跳过待删除结点
     * 1、如果待删除的结点是尾结点，由于单链表不知道其前结点，没有办法删除
     * 2、如果删除的结点不是尾结点，则将其该结点的值与下一结点交换，然后该结点的指针指向下一结点的后续结点
     */
    public boolean deleteSpecialNode(Node n){
        if(n.next == null){
            return false;
        }else{
            //交换结点和其后续结点中的数据
            int temp = n.val;
            n.val = n.next.val;
            n.next.val = temp;
            //删除后续结点
            n.next = n.next.next;
            return true;
        }
    }


    /**
     * 判断两个链表是否相交：
     * 两个链表相交，则它们的尾结点一定相同，比较两个链表的尾结点是否相同即可
     */
    public boolean isCross(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1.next != null){
            temp1 = temp1.next;
        }
        while(temp2.next != null){
            temp2 = temp2.next;
        }
        if(temp1 == temp2){
            return true;
        }
        return false;
    }


    /**
     * 如果链表相交，求链表相交的起始点：
     * 1、首先判断链表是否相交，如果两个链表不相交，则求相交起点没有意义
     * 2、求出两个链表长度之差：len=length1-length2
     * 3、让较长的链表先走len步
     * 4、然后两个链表同步向前移动，没移动一次就比较它们的结点是否相等，第一个相等的结点即为它们的第一个相交点
     */
    public Node findFirstCrossPoint(SingleLinkedList linkedList1, SingleLinkedList linkedList2){
        //链表不相交
        if(!isCross(linkedList1.head,linkedList2.head)){
            return null;
        }else{
            int length1 = linkedList1.length();//链表1的长度
            int length2 = linkedList2.length();//链表2的长度
            Node temp1 = linkedList1.head;//链表1的头结点
            Node temp2 = linkedList2.head;//链表2的头结点
            int len = length1 - length2;//链表1和链表2的长度差

            if(len > 0){//链表1比链表2长，链表1先前移len步
                for(int i=0; i<len; i++){
                    temp1 = temp1.next;
                }
            }else{//链表2比链表1长，链表2先前移len步
                for(int i=0; i<len; i++){
                    temp2 = temp2.next;
                }
            }
            //链表1和链表2同时前移,直到找到链表1和链表2相交的结点
            while(temp1 != temp2){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return temp1;
        }
    }

    //两个参数代表的是两个链表的头结点
    public Node mergeLinkList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {  //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head; //新链表的头结点
        Node current;  //current结点指向新链表
        // 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.val <= head2.val) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;  //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }
        //合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }
        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }
        return head;
    }


        public Node merge(Node head1, Node head2) {
            if(head1 == null){
                return head2;
            }
            if(head2 == null){
                return head1;
            }
            Node head = null;
            if(head1.val <= head2.val){
                head = head1;
                head.next = merge(head1.next,head2);
            }else{
                head = head2;
                head.next = merge(head1,head2.next);
            }
            return head;
        }







    public static void main(String[] args){
        SingleLinkedList linkList = new SingleLinkedList();
        SingleLinkedList linkList2 = new SingleLinkedList();
        SingleLinkedList linkList3 = new SingleLinkedList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
//        linkList.add(4);
//        linkList.add(5);
        linkList2.add(1);
        linkList2.add(3);
        linkList2.add(4);



//        System.out.println(linkList.length());

//        linkList.deleteNode(1);
//        linkList.deleteNode(3);
//        linkList.deleteNode(5);
//        System.out.println(linkList.length());

//        Node n1 = linkList.getNodeByIndex(3);
//        System.out.println(n1.val);

//        Node n2 = linkList.findReverNode(4);
//        System.out.println(n2.val);

//        linkList.reserveLink();
//        System.out.println(linkList);

        linkList.reservePrt(linkList.head);
//        linkList.reservePrt2(linkList.head);

//        Node n3 = linkList.findMiddleNode();
//        System.out.println(n3.val);

//        boolean ringed = linkList.isRinged();
//        System.out.println(ringed);
//        Node lastNode = linkList.getLastNode();
//        lastNode.next = linkList.findMiddleNode();
//        boolean ringed2 = linkList.isRinged();
//        System.out.println(ringed2);
//
//        int cycleLength = linkList.getCycleLength();
//        System.out.println(cycleLength);

        //linkList3.head = linkList3.mergeLinkList(linkList.head, linkList2.head);
        //linkList3.head = linkList3.merge(linkList.head, linkList2.head);
    }


}
