
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
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

    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            Node cur = new Node();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                if (i == 0){
                    cur = tmp;
                }else {
                    cur.next = tmp;
                    cur = cur.next;
                }
                if (tmp.left != null){
                    queue.offer(tmp.left);
                }
                if (tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
        }
        return root;

    }


    private Map<TreeNode,Integer> map  = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        int value1 = root.val;
        if (map.containsKey(root)){
            return map.get(root);
        }
        if (root.left != null){
            value1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            value1 += rob(root.right.left) + rob(root.right.right);;
        }
        int value2 = rob(root.left) + rob(root.right);
        int result = Math.max(value2,value1);
        map.put(root,result);
        return  result;
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    int res ;
    public int maxPath(TreeNode root){
        if (root == null){
            return 0;
        }
        getHeight(root);
        return res;
    }
    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        res = Math.max(res,left+right);
        return 1 + Math.max(left,right);
    }

    int min = Integer.MIN_VALUE;
    public int getMaxValue(TreeNode root){
        if (root == null){
            return 0;
        }
        getValue(root);
        return min;
    }

    private int getValue(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getValue(root.left);
        int right = getHeight(root.right);
        min = Math.max(min,left+right+root.val);
        return root.val + Math.max(left,right);
    }


    public static String tree2str(TreeNode root) {
        if (root == null){
            return "";
        }
        inorder(root);
        return sb.toString();

    }
    public static StringBuilder sb = new StringBuilder();

    private static void inorder(TreeNode node){
        if (node == null){
            return;
        }
        sb.append(node.val);
        if(node.left!=null || (node.left==null &&node.right!=null)){
            sb.append("(");
            inorder(node.left);
            sb.append(")");
        }
        if(node.right!=null){
            sb.append("(");
            inorder(node.right);
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        String s = tree2str(root);
        //1(2(4))(3)
        //1(2(4)())(3())
        System.out.println(s);
    }
    
}
