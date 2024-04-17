package linkedlist;
/**
 * @Author zzy
 * @Description 两两交换元素
 */
public class SwapPairs {
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
        test(listNode);
    }
    // 不采用虚拟节点的做法
    public static ListNode test(ListNode head) {
        ListNode curentNode = head;
        ListNode firstNode = null;
        ListNode secondNode = null;
        ListNode tempNode = null;
        ListNode newHead = null;
        if (curentNode == null || curentNode.next == null) {
            return head;
        }
        boolean loop = true;
        while (curentNode != null && curentNode.next != null) {
            if (!loop) {
                firstNode.next = curentNode.next;
            }
            firstNode = curentNode;
            secondNode = curentNode.next;
            if (loop) {
                newHead = firstNode.next;
                loop = false;
            }

            tempNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode.next = tempNode;
            curentNode = tempNode;
        }
        return newHead;
    }
    // 采用虚拟节点
    public static ListNode test2(ListNode head) {
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode temp = null;
        ListNode firstNode = null;
        ListNode secondNode = null;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dumyhead.next;
    }
}
