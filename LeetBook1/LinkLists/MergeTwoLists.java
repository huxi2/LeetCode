package LinkLists;

import org.junit.Test;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode new_head = new ListNode(), r = new_head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                r.next = list1;
                r = list1;
                list1 = list1.next;
            } else {
                r.next = list2;
                r = list2;
                list2 = list2.next;
            }
        }
        r.next = list1 != null ? list1 : list2;
        return new_head.next;
    }

    @Test
    public void mytest() {
        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head2 = new ListNode(1);
        ListNode n22 = new ListNode(2);
        ListNode n32 = new ListNode(4);
        ListNode n42 = new ListNode(4);
        ListNode n52 = new ListNode(5);
        head2.next = n22;
        n22.next = n32;
        n32.next = n42;
        n42.next = n52;

        ListNode res = mergeTwoLists(head1, head2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
