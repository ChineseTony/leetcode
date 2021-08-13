import java.util.Map;
import java.util.TreeMap;

/**
 * @author wangtao
 * @date 2021/8/13
 */
public class MyTrie {
    private Node root;


    public MyTrie(){
        root = new Node();
    }


    public void insert(int num){
        Node cur = root;
        for (int i = 31; i >=0; i--) {
            int tmp = (num >> i) & 1;
            if (!cur.next.containsKey(tmp)){
                cur.next.put(tmp,new Node());
            }
            cur = cur.next.get(tmp);
        }
    }

    public int query(int num){
        Node cur = root;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int tmp = (num >> i) & i ;
            if (tmp == 0){
                if (cur.next.containsKey(1)) {
                    result += 1 << i;
                    cur = cur.next.get(1);
                }else{
                    cur = cur.next.get(0);
                }
            }else {
                if (cur.next.containsKey(0)) {
                    cur = cur.next.get(0);
                }else{
                    result += 1 << i  ;
                    cur = cur.next.get(1);
                }
            }
        }
        return result;
    }




    private class Node{
        //标志是不是单词结尾
        public boolean isWord;
        public Map<Integer,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

    }

    public static void main(String[] args) {
        MyTrie trie = new MyTrie();
        int[] nums = new int[]{3,10,5,25,2,8};
        int result = 0;
        for (int num:nums){
            trie.insert(num);
        }
        for (int num:nums){
            result = Math.max(result,num ^ trie.query(num));
        }
        System.out.println(result);
    }
}
