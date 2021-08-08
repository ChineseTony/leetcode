/**
 * @author wangtao
 * @date 2021/8/8
 */
public class MyLinkedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                ListNode tmp = current.next;
                current.next = tmp.next;
                tmp.next = null;
            }else {
                pre = pre.next;
                current = current.next;
            }
        }
        return dummy.next;

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        for (int i = 0; i < 10; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        printListNode(dummy.next);
        ListNode result = reverse(dummy.next);
        printListNode(result);
        ListNode reverseNode= reverseKGroup(result,3);
        printListNode(reverseNode);
    }

    public static void printListNode(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode nextNode = cur.next;
        while (nextNode != null){
            cur.next = nextNode.next;
            nextNode.next = dummy.next;
            dummy.next = nextNode;
            nextNode = cur.next;
        }
        return dummy.next;
    }
}
