import org.junit.Test;

/*
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 链表合并
 */
public class LeetCode0021 {
    //链表操作  非递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode r = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                r.next = l1;
                r = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                r = l2;
                l2 = l2.next;
            }
        }
        r.next = l1 != null ? l1 : l2;
        return res.next;
    }

    //递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                return new ListNode(l1.val, mergeTwoLists2(l1.next, l2));
            } else {
                return new ListNode(l2.val, mergeTwoLists2(l1, l2.next));
            }
        }
        if (l1 != null) return l1;
        return l2;
    }

    @Test
    public void mytest() {
        ListNode temp = new ListNode(5);
        temp = new ListNode(4, temp);
        ListNode l0 = new ListNode(2, temp);

        temp = new ListNode(4);
        temp = new ListNode(3, temp);
        ListNode l1 = new ListNode(1, temp);
        ListNode res = mergeTwoLists2(l0, l1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}