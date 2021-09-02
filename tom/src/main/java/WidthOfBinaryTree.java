
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wangtao
 * @date 2021/9/2
 */
public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        if (root == null){
            return result;
        }
        Queue<TreeNodeIndex> queue = new ArrayDeque<>();
        queue.offer(new TreeNodeIndex(0,root));
        while (!queue.isEmpty()){
            int start = 0;
            int end = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNodeIndex poll = queue.poll();
                int id = poll.index;
                TreeNode node = poll.node;
                if (i == 0) {
                    start = id;
                }
                if (i == len-1) {
                    end = id;
                }
                if (node.left != null){
                    queue.offer(new TreeNodeIndex(2* id +1, node.left));
                }
                if (node.right != null){
                    queue.offer(new TreeNodeIndex(2* id +2, node.right));
                }
            }
            result = Math.max(result,end-start+1);
        }
        return result;

    }
    
    class TreeNodeIndex{
         int index;
         TreeNode node;

        public TreeNodeIndex(int index, TreeNode node) {
            
            this.index = index;
            this.node = node;
        }
    }
    
    
}
