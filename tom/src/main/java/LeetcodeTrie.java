
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/10/4
 */
public class LeetcodeTrie {

    private TreeNode root;


    public LeetcodeTrie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (!cur.next.containsKey(tmp)){
                cur.next.put(tmp,new TreeNode());
            }
            cur = cur.next.get(tmp);
        }
        cur.isEnd = true;

    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            if (!cur.next.containsKey(tmp)){
                return false;
            }
            cur = cur.next.get(tmp);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        int length = prefix.length();
        for (int i = 0; i < length ; i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }


    public boolean startsWithReg(String reg) {

        return match(root,reg,0);

    }

    private boolean match(TreeNode root,String word,int index){
        if (index == word.length()){
            return root.isEnd;
        }
        if (word.charAt(index) != '*'){
            if (root.next.get(word.charAt(index)) == null){
                return false;
            }
            return match(root.next.get(word.charAt(index)),word,index+1);
        }else {
            for (Map.Entry<Character,TreeNode>  entry:root.next.entrySet()){
               if (match(entry.getValue(),word,index+1)){
                   return true;
               }
            }
            return false;
        }
    }


    public class TreeNode{
        char c;
        Map<Character,TreeNode> next;
        boolean isEnd;

        public TreeNode(){
            next = new HashMap<>(26);
            isEnd = false;
        }
    }
}
