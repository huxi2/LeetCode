import org.junit.Test;

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
*/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class LeetCode0002 {
    //使用链表操作
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode r = result;
        //进位标志
        int flag = 0;
        int temp = 0;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + flag;
            if (temp >= 10) {
                flag = 1;
                temp -= 10;
            } else {
                flag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            r.next = new ListNode(temp);
            r = r.next;
        }

        l1 = l1 == null ? l2 : l1;
        while (l1 != null) {
            temp = l1.val + flag;
            if (temp >= 10) {
                flag = 1;
                temp -= 10;
            } else {
                flag = 0;
            }
            r.next = new ListNode(temp);
            r = r.next;
            l1 = l1.next;
        }
        if (flag == 1) {
            r.next = new ListNode(1);
        }

        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int flag = 0, temp = 0, temp1 = 0, temp2 = 0;
        ListNode result = null, r = null;
        while (l1 != null || l2 != null || flag != 0) {
            temp1 = l1 == null ? 0 : l1.val;
            temp2 = l2 == null ? 0 : l2.val;
            temp = temp1 + temp2 + flag;
            if (temp >= 10) {
                flag = 1;
                temp = temp - 10;
            } else {
                flag = 0;
            }
            //创建链表
            if (r == null) {
                r = new ListNode(temp);
                result = r;
            } else {
                r.next = new ListNode(temp);
                r = r.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return result;
    }


    //使用递归
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int flag) {
        int temp = 0;
        ListNode result = null;
        if (l1 != null && l2 != null) {
            temp = l1.val + l2.val + flag;
            if (temp >= 10) {
                result = new ListNode(temp - 10, add(l1.next, l2.next, 1));
            } else {
                result = new ListNode(temp, add(l1.next, l2.next, 0));
            }
        } else if (l1 != null || l2 != null) {
            if (l1 != null) {
                temp = l1.val + flag;
                if (temp >= 10) {
                    result = new ListNode(temp - 10, add(l1.next, null, 1));
                } else {
                    result = new ListNode(temp, add(l1.next, null, 0));
                }
            } else {
                temp = l2.val + flag;
                if (temp >= 10) {
                    result = new ListNode(temp - 10, add(null, l2.next, 1));
                } else {
                    result = new ListNode(temp, add(null, l2.next, 0));
                }
            }
        } else {
            if (flag == 1) {
                result = new ListNode(1);
            }
        }

        return result;
    }

    @Test
    public void mytest() {
        ListNode temp = new ListNode(3);
        temp = new ListNode(4, temp);
        ListNode l0 = new ListNode(2, temp);

        temp = new ListNode(4);
        temp = new ListNode(6, temp);
        ListNode l1 = new ListNode(5, temp);
        temp = l0;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        temp = l1;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        ListNode result = addTwoNumbers1(l0, l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
