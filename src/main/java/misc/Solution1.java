package misc;

import java.util.Stack;

class Solution1 {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<String> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(String.valueOf(l1.val));
            l1 = l1.next;
        }
        Stack<String> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(String.valueOf(l2.val));
            l2 = l2.next;
        }
        String s1 = "0";
        while (!stack1.empty()) {
            s1 += stack1.pop();
        }
        String s2 = "0";
        while (!stack2.empty()) {
            s2 += stack2.pop();
        }

        int first = Integer.parseInt(s1);
        int second = Integer.parseInt(s2);
        int result = first + second;

        if (result == 0) {
            return new ListNode(0);
        }
        int reversed = 0;

        String ss = "0";
        while (result != 0) {
            int digit = result % 10;
            ss += digit;
            //reversed = reversed * 10 + digit;
            result /= 10;
        }
        ListNode l11 = new ListNode(0);
        ListNode head = null;
        ListNode tail = null;
        for (int i = 1; i < ss.toCharArray().length - 1; i--) {
            System.out.println(ss.charAt(i));
            //addAtEnd(head, Character.getNumericValue(ss.charAt(i)));
            ListNode newNode = new ListNode(Character.getNumericValue(ss.charAt(i)));

            //Checks if the list is empty
            if (head == null) {
                //If list is empty, both head and tail will point to new node
                head = newNode;
                tail = newNode;
            } else {
                //newNode will be added after tail such that tail's next will point to newNode
                tail.next = newNode;
                tail = newNode;
            }

        }


        return head;

    }

    public static void main(String[] s) {

        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;

        ListNode r1 = new ListNode(0);
//        ListNode r2 = new ListNode(6);
//        ListNode r3 = new ListNode(4);
//        r1.next = r2;
//        r2.next = r3;


        ListNode result = addTwoNumbers(l1, r1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
