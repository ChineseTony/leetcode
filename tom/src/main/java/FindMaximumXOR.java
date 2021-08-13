

/**
 * @author wangtao
 * @date 2021/8/13
 */
public class FindMaximumXOR {

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                result = Math.max(result,nums[i] ^ nums[j]);
            }
        }
        return result;
    }


    public static int findMaximumXOR2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int result = 0;
        Trie trie = new Trie();
        for (int num:nums){
            trie.insert(num);
        }
        for (int num:nums){
            result = Math.max(result,num ^ trie.query(num));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
        System.out.println(findMaximumXOR2(nums));
    }


    static class Trie{
        Node root;


        public Trie(){
            root = new Node();
        }

        public class Node{
            Node one;
            Node zero;
            int val;
            public Node(){

            }
        }

        public void insert(int num){
            Node cur = root;
            for (int i = 31; i >=0; i--) {
                int tmp = (num >> i) & 1;
                if (tmp == 0){
                    if (cur.zero == null){
                        cur.zero = new Node();
                    }
                    cur = cur.zero;
                }else {
                    if (cur.one == null){
                        cur.one = new Node();
                    }
                    cur = cur.one;
                }
            }
            cur.val = num;
        }

        public int query(int num){
            Node cur = root;
            for (int i = 31; i >=0; i--) {
                int tmp = (num >> i) & 1;
                if (tmp == 0){
                    if (cur.one != null){
                        cur = cur.one;
                    }else {
                        cur = cur.zero;
                    }
                }else {
                    if (cur.zero != null){
                        cur = cur.zero;
                    }else {
                        cur = cur.one;
                    }
                }

            }
            return cur.val;
        }
    }

}
