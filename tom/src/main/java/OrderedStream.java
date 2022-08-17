import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2022/8/16
 */
public class OrderedStream {



    public OrderedStream(int n) {

    }

    public List<String> insert(int idKey, String value) {


        return null;
    }


    public int deepestLeavesSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            result = sum;
        }
        return result;
    }



}
