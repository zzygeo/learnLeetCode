package linkedlist;

/**
 * 删除元素，头节点非空
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode result = test(listNode1, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode test(ListNode head, int val) {
       ListNode temp = head;
       // 删除头结点
       while (temp != null && temp.val == val) {
           temp = temp.next;
       }
       // 删除非头结点
       ListNode cur = temp;
       while (cur != null && cur.next != null) {
           if (cur.next.val == val) {
               cur.next = cur.next.next;
           } else {
               cur = cur.next;
           }
       }
       return temp;
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

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
