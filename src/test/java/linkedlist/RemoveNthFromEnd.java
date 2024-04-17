package linkedlist;
/**
 * @Author zzy
 * @Description 从链表末尾删除元素
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        test3(listNode, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode test(ListNode head, int n) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        int indexToRemove = size - n;
        if (indexToRemove == 0) {
            return head.next;
        }

        if (indexToRemove < 0) {
            return head;
        }

        current = head;
        for (int i = 0; i < indexToRemove - 1; i++) {
            current = current.next;
        }
        if (current.next.next == null) {
            current.next = null;
        } else {
            current.next = current.next.next;
        }
        return head;
    }
    // 利用双指针，遍历一遍就完成删除
    public static ListNode test2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        if (n < 1) {
            return head;
        }

        // 快指针先走n + 1步
        for (int i = 0; i < n + 1; i++) {
           if (fast != null) {
               fast = fast.next;
           } else {
               return head.next;
           }
        }
        // 慢针和快针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next.next == null) {
            slow.next = null;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
    // 基于辅助节点的双指针遍历，在涉及到需要用到上一个节点
    public static ListNode test3(ListNode head, int n) {
        ListNode dumyNode = new ListNode(-1);
        dumyNode.next = head;
        ListNode slow = dumyNode;
        ListNode fast = dumyNode;

        if (n < 1) {
            return head;
        }

        // 快指针先走n步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 快慢指针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除节点
        slow.next = slow.next.next;

        return dumyNode.next;
    }
}
