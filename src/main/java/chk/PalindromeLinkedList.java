package chk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeLinkedList {

    public static void main(String[] args) {

        PalindromeLinkedList pll = new PalindromeLinkedList();

        System.out.println(pll.isPalindrome(pll.createLinkedList(-129, -129)));

    }

    private ListNode createLinkedList(int... args) {

        ListNode head = new ListNode(args[0]);
        ListNode now = head;

        if (args.length > 1) {
            for (int idx = 1; idx < args.length; idx++) {
                ListNode node = new ListNode(args[idx]);
                now.next = node;
                now = node;
            }
        }

        return head;
    }

    public boolean isPalindrome(ListNode head) {

        Object[] arr = parseLinkedListToStringArr(head);

        System.out.println(Arrays.toString(arr));

        return isPalindrome(arr);
    }

    private boolean isPalindrome(Object[] arr) {

        if (arr.length < 2) {
            return true;
        }

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            if(arr[start].equals(arr[end])){
                start++; end--;
            } else {
                return false;
            }

        }


        return true;
    }

    private Object[] parseLinkedListToStringArr(ListNode head) {

        List<String> toret = new ArrayList<>();
        ListNode now = head;

        while (now != null) {
            toret.add(now.val + "");
            now = now.next;
        }

        return toret.toArray();
    }

    private boolean isPalindrome(int num) {
        if (num < 0) return false;
        int reversed = 0, remainder, original = num;
        while (num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num /= 10;  //the last digit is removed from num after division by 10.
        }
        // palindrome if original and reversed are equal
        return original == reversed;
    }

    private int parseLinkedList(ListNode node, int number) {
        if (node == null) {
            return number;
        }
        number = number * 10 + node.val;
        return parseLinkedList(node.next, number);
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
