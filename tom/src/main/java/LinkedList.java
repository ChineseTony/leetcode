/**
 * @author wangtao
 * @date 2021/8/7
 */
public class LinkedList {


    public ListNode deleteDuplicates(ListNode head) {
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


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
