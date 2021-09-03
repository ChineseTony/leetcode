import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/9/3
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> tmp = new ArrayList<>();
        travel(root,tmp);
        for (int i = 0; i < tmp.size() - 1; i++) {
            tmp.get(i).right = tmp.get(i+1);
            tmp.get(i).left = null;
        }
    }

    private void travel(TreeNode root,List<TreeNode> tmp){
        if (root != null){
            tmp.add(root);
            travel(root.left,tmp);
            travel(root.right,tmp);
        }
    }
}
