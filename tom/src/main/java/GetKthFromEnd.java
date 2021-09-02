/**
 * @author wangtao
 * @date 2021/9/2
 */

public class GetKthFromEnd {
    public MyLinkedList.ListNode getKthFromEnd(MyLinkedList.ListNode head, int k) {
        if (head == null || k <= 0){
            return head;
        }
        int len = 0;
        MyLinkedList.ListNode dummy = new MyLinkedList.ListNode(-1);
        dummy.next = head;
        MyLinkedList.ListNode pre = dummy;
        MyLinkedList.ListNode next = dummy;
        while (pre != null && k-- >0){
            pre = pre.next;
        }
        if (pre == null){
            return null;
        }
        while (pre != null){
            pre = pre.next;
            next = next.next;
        }
        return next;
    }
}
