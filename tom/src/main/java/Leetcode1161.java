import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2022/7/31
 */
public class Leetcode1161 {

    public int maxLevelSum(TreeNode root) {
        int level = 0;
        int result = 1;
        int sum = root.val;
        Queue<TreeNode>  queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int tmpVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                tmpVal += tmp.val;
                if (tmp.left != null){
                    queue.offer(tmp.left);
                }
                if (tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            level++;
            if (tmpVal > sum){
                sum = tmpVal;
                result = level;
            }
        }
        return result;
    }


}
