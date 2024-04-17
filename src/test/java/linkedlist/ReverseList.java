package linkedlist;
/**
 * @Author zzy
 * @Description 反转链表
 */
public class ReverseList {

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

    public static ListNode test(ListNode head) {
        ListNode curentNode = head;
        ListNode preNode = null;
        // 可能为null
        if (curentNode != null) {
           ListNode temp = curentNode.next;
           curentNode.next = preNode;
           preNode = curentNode;
           curentNode = temp;
        }
        return preNode;
    }
}
