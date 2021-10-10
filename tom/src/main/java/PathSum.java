import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/9/9
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        dfs(result,tmp,root,0,targetSum);
        return result;

    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' &&
                    ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    private void dfs(List<List<Integer>> result,
                     List<Integer> tmp,TreeNode root,int sum,int targetSum){
        if (root == null ){
            return;
        }
        tmp.add(root.val);
        sum += root.val;
        if (sum  == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(tmp));
        }
        dfs(result,tmp,root.left,sum,targetSum);
        dfs(result,tmp,root.right,sum,targetSum);
        tmp.remove(tmp.size()-1);
    }


    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<Integer> tmp = new ArrayList<>();
        dfs(tmp,root,0);
        int sum = 0;
        for (int i:tmp){
            sum += i;
        }
        return sum;
    }

    private void dfs(List<Integer> tmp,TreeNode root,int sum){
        if (root == null){
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            tmp.add(sum);
            return;
        }
        dfs(tmp,root.left,sum);
        dfs(tmp,root.right,sum);
    }

    public int sumNumbers2(TreeNode root) {
        if (root == null){
            return 0;
        }
        return dfsNumber(root,0);
    }

    private int dfsNumber(TreeNode node,int sum){
        if (node == null){
            return  0;
        }
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null){
            return sum;
        }
        return dfsNumber(node.left,sum) + dfsNumber(node.right,sum);
    }



}
