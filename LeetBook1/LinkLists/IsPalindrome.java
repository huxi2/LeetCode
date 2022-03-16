package LinkLists;

import org.junit.Test;

import java.util.Stack;

public class IsPalindrome {
    public int countLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    public boolean isPalindrome(ListNode head) {
        int len = countLength(head);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (len % 2 != 0) {
            head = head.next;
        }

        while (!stack.isEmpty() && head!=null && head.val == stack.peek()) {
            stack.pop();
            head = head.next;
        }
        return stack.isEmpty();
    }

    @Test
    public void mytest() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(isPalindrome(head));

    }
}
