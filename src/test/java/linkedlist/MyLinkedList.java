package linkedlist;

class MyLinkedList {
    ListNode head;

    public MyLinkedList() {
        // 初始化头结点
        head = new ListNode();
    }

    public int get(int index) {
        // 无效的下标
        if (index < 0) {
            return -1;
        }
        ListNode temp = head;
        int size = 0;
        int val = -1;
        while (temp.next != null) {
            temp = temp.next;
            if (size == index) {
                val = temp.val;
            }
            size++;
        }
        return val;
    }

    public void addAtHead(int val) {
        ListNode newNode =  new ListNode(val);
        ListNode temp = head;
        if (temp.next == null) {
            temp.next = newNode;
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        // 判断是不是直接插入到了头节点后面一个

        int size = 0;
        while (temp.next != null) {
            if (size == index) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
            size++;
        }
        if (size == index) {
            temp.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }

        ListNode temp = head;
        int size = 0;
        while (temp.next != null) {
            if (size == index) {
                temp.next = temp.next.next;
            }
            if (temp.next != null) {
                temp = temp.next;
            }
            size++;
        }
    }
}
