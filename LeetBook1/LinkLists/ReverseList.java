package LinkLists;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode new_head = new ListNode(0, null), r;
        //头插法
        while (head != null) {
            r = head.next;
            head.next = new_head.next;
            new_head.next = head;
            head = r;
        }
        return new_head.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode q = null, r = head;
        //逆置链表的指向
        while (r != null) {
            ListNode temp = r;
            r = r.next;
            temp.next = q;
            q = temp;
        }
        return q;
    }
}
