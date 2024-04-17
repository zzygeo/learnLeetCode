package linkedlist;
/**
 * @Author zzy
 * @Description 找出环形链表的入口
 */
public class DetectCycle {
    public static void main(String[] args) {

    }

    public static ListNode test(ListNode head) {
        // 循环入口点步长x，相遇点距离入口点y，相遇点距离入口点z
        // 则有 2 * (x + y) = n * (y + z) + y + x;
        // x = (n -1)(y + z) + z
        // 则说明入口点等于两点相遇以后，从相遇点出发一个指针，从起点出发一个指针，这两相遇的位置则是入口点
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != fast) {
                    head = head.next;
                    // 相遇一定是在环内的
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }
}
