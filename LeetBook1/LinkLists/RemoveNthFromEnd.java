package LinkLists;

import org.junit.Test;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode(0);
        new_head.next = head;
        ListNode first = head, preDeNode = new_head;

        int i = 0;
        while (i < n) {
            first = first.next;
            i++;
        }

        while (first != null) {
            first = first.next;
            preDeNode = preDeNode.next;
        }
        if (preDeNode.next != null)
            preDeNode.next = preDeNode.next.next;

        return new_head.next;
    }

    @Test
    public void mytest() {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode res = removeNthFromEnd(head, -1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
