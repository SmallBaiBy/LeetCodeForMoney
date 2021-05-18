package leetcodeCC;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
// 示例 1：
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
public class AddMark {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode p1 = l1, p2 = l2;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);

        ListNode l3 = addNumbers(p1, p2);
        l3 = l3.next;
        while (l3 != null) {
            System.out.println(l3.val);
            if (l3.next == null) {
                break;
            }
            l3 = l3.next;
        }
    }

    public static ListNode addNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode pre = l1, las = l2;
        ListNode cur = l3;
        //记录进位产生
        int count = 0;
        while (pre != null || las != null) {
            int x = (pre != null) ? pre.val : 0;
            int y = (las != null) ? las.val : 0;

            int sum = x + y + count;
            count = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (pre.next == null && las.next == null) {
                break;
            }
            if (pre != null) {
                pre = pre.next;
            }
            if (las != null) {
                las = las.next;
            }
        }
        if (count != 0) {
            cur.next = new ListNode(count);
        }
        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}
