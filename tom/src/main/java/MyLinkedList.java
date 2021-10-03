import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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
        System.out.println(isPalindrome2(dummy.next));
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

    public ListNode addListNode(ListNode p,ListNode q){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode pCur = p;
        ListNode qCur = q;
        int ord = 0;
        while (pCur != null ||  qCur != null){
            int sum = 0;
            if (pCur != null){
                sum += pCur.val;
            }
            if (qCur != null){
                sum += qCur.val;
            }
            sum += ord;
            int val = sum % 10;
            tail.next = new ListNode(val);
            tail = tail.next;
            ord = sum / 10 ;
            if (pCur != null) {
                pCur = pCur.next;
            }
            if (qCur != null) {
                qCur = qCur.next;
            }
        }
        if (ord != 0){
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        Set<Integer> set = new HashSet<>();
        while (cur != null ){
            if (set.contains(cur.val)){
                ListNode  next  = cur.next;
                pre.next = cur.next;
                cur.next = null;
                cur = next;
            }else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public ListNode partition(ListNode head, int x) {
        ListNode large = new ListNode(-1);
        ListNode small = new ListNode(-1);
        ListNode l = large;
        ListNode s = small;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                s.next = cur;
                s = s.next;
            }else {
                l.next = cur;
                l = l.next;
            }
            cur = cur.next;
        }
        l.next = null;
        s.next = large.next;
        return small.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        return head;
    }


    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = head;
        while (cur != null){
            stringBuilder.append(cur.val);
            cur = cur.next;
        }
        String tmp = stringBuilder.toString();
        String tmp2 = stringBuilder.reverse().toString();
        return tmp.equals(tmp2);
    }


    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            stack.push(slow);
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        while (slow != null && !stack.isEmpty()){
            ListNode poll = stack.poll();
            if (poll.val != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    private static ListNode getMiddle(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
