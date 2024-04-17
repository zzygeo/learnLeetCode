package linkedlist;
/**
 * @Author zzy
 * @Description 获取两个链表相交的节点，若不相交则返回null
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);

        ListNode listNode6 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode6.next = listNode4;
        getIntersectionNode(listNode, listNode6);
    }

    /**
     * 注意，如果两个链表相交，表示指向的是同一个节点，而不仅仅是数值相等
     * 可以观察到，节点相等以后的数据部分的长度是一样的，所以可以先将长的节点移动
     * 到和短的一样长，然后再一起遍历，找到相等的节点
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先遍历出链表的长度
        int headASize = 0;
        int headBSize = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            headASize++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            headBSize++;
            tempB = tempB.next;
        }
        // 算出两个链表的长度差
        int diff = Math.abs(headASize - headBSize);

        // 移动长的链表的指针，使得两个链表的长度相等
        if (headASize > headBSize) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else if (headASize < headBSize) {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }
        // 一起移动，直到next相等就返回节点
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
