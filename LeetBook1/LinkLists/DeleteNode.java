package LinkLists;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        // 将后值复制然后删除下节点
        node.val = temp.val;
        node.next = temp.next;
    }

}
