
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/3
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }

    private boolean isSub(TreeNode a,TreeNode b){
        if (b == null){
            return true;
        }
        if (a == null){
            return false;
        }
        return a.val == b.val
                && isSub(a.left,b.left) && isSub(a.right,b.right);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        List<TreeNode> pParent = new ArrayList<>();
        List<TreeNode> qParent = new ArrayList<>();
        getParents(root,p,new ArrayList<>(),pParent);
        getParents(root,q,new ArrayList<>(),qParent);
        int index = 0;
        int qLen = qParent.size();
        int pLen = pParent.size();
        while (index < qLen && index < pLen){
            if (!pParent.get(index).equals(qParent.get(index))) {
                break;
            }
            index ++;
        }

        if (index > qLen || index > pLen){
            return null;
        }else {
            return pParent.get(index-1);
        }

    }

    /**
     * 回溯算法
     * @param root
     * @param tmp
     * @param parents
     */
    private void getParents(TreeNode root,TreeNode tmp,
                            List<TreeNode> tmpList,List<TreeNode> parents){
        if (root == null){
            return;
        }
        tmpList.add(root);
        if (root == tmp){
            parents.addAll(tmpList);
            return;
        }
        getParents(root.left,tmp,tmpList,parents);
        getParents(root.right,tmp,tmpList,parents);
        tmpList.remove(tmpList.size()-1);
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
       if (root == p || root == q){
           return root;
       }
       TreeNode left = lowestCommonAncestor2(root.left,p,q);
       TreeNode right = lowestCommonAncestor2(root.right,p,q);
       if (left != null && right != null){
           return root;
       }
       if (left != null){
           return left;
       }
       if (right != null){
           return right;
       }
       return null;
    }

}
