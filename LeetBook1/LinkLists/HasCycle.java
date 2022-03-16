package LinkLists;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        // 快慢指针法
        ListNode first = head.next, second = head;
        while (first != null && first == second) {
            first = first.next;
            if (first != null) first = first.next;
            second = second.next;
        }
        return first == second;
    }

}
