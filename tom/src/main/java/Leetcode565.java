/**
 * @author wangtao
 * @date 2022/7/17
 */
public class Leetcode565 {


    private TreeNode next;


    public TreeNode convertBiNode(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBiNode(root.right);
        root.right = next;
        next = root;
        convertBiNode(root.left);
        root.left = null;
        return next;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }


    public static int arrayNesting(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int length = nums.length;
        int result = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] < 0){
                continue;
            }
            int count = 0;
            int tmp = j;
            while (nums[tmp] >= 0) {
                count++;
                int index = nums[tmp];
                nums[tmp] = -1;
                tmp = index;
            }
            result = Math.max(count,result);
        }
        return result;
    }

    public static void main(String[] args) {
//        S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
        int[] tmp = new int[]{5,4,0,3,1,6,2};
        System.out.println(arrayNesting(tmp));
    }
}
