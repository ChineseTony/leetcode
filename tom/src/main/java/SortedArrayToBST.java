import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2021/9/8
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> tmp = new ArrayDeque<>();
        Queue<Integer> left= new ArrayDeque<>();
        Queue<Integer> right = new ArrayDeque<>();
        tmp.add(root);
        left.offer(0);
        right.offer(nums.length-1);
        while (!tmp.isEmpty()){
            TreeNode poll = tmp.poll();
            int leftVal = left.poll();
            int rightVal = right.poll();
            int mid = (rightVal - leftVal) / 2 + leftVal;
            poll.val = nums[mid];
            if (leftVal < mid){
                TreeNode curLeft = new TreeNode(-1);
                poll.left = curLeft;
                tmp.offer(curLeft);
                left.offer(leftVal);
                right.offer(mid-1);
            }
            if (mid < rightVal){
                TreeNode curRight = new TreeNode(-1);
                poll.right = curRight;
                tmp.offer(curRight);
                left.offer(mid+1);
                right.offer(rightVal);
            }
        }
        return root;

    }
}
