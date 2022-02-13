

/**
 * @author wangtao
 * @date 2022/2/12
 */
public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head){
        if (head == null){
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        return sortedListToBST(head,null);
    }

    public TreeNode sortedListToBST(ListNode left,ListNode right) {
        if (left == right){
            return null;
        }
        ListNode mid = getMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(left,mid);
        root.right  = sortedListToBST(mid.next,right);
        return root;
    }

    private ListNode getMid(ListNode left,ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
