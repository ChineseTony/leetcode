
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtao
 * @date 2021/8/19
 */
public class Trie {

    private TreeNode root;

    public  Trie(){
        root = new TreeNode();
    }

    public void  buildTree(List<String> stringList){
        int len = stringList.size();
        String tmp = "";
        for (int i = 0; i < len; i++) {
            tmp = stringList.get(i);
            int tmpLength = tmp.length();
            TreeNode tmpNode = root;
            for (int j = 0; j < tmpLength; j++) {
                String s = tmp.charAt(j) + "";
                if (!tmpNode.next.containsKey(s)){
                    tmpNode.next.put(s,new TreeNode());
                }
                tmpNode = tmpNode.next.get(s);
            }
            tmpNode.isEnd = true;
        }

    }

    public List<String> findString(String str){
        List<String> result = new ArrayList<>();
        dfs(root,str,0,result,new StringBuilder());
        return result;
    }

    private void dfs(TreeNode tmp,String s,int index,
                     List<String> result,StringBuilder stringBuffer){
        if (tmp.isEnd && index >= s.length()){
            result.add(new String(stringBuffer));
        }
        for (int i = index; i < s.length(); i++) {
            String tmpString = s.charAt(i)+"";
            if (!tmp.next.containsKey(tmpString)){
                continue;
            }
            stringBuffer.append(tmpString);
            dfs(tmp.next.get(tmpString), s,index+1,result,stringBuffer);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if (index >= s.length() ){
            for (Map.Entry<String,TreeNode> entry:tmp.next.entrySet()){
                String tmpValue = entry.getKey();
                stringBuffer.append(tmpValue);
                dfs(entry.getValue(), s,index+1,result,stringBuffer);
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(Arrays.
                asList("粉笔", "粉笔公考", "粉笔考研","高途教育","高途教学","高途"));
        Trie trie = new Trie();
        trie.buildTree(logs);
        List<String> string = trie.findString( "粉笔");
        string.parallelStream().forEach(System.out::println);
    }

    static class TreeNode{
        private String  value;
        private Map<String,TreeNode> next;
        private boolean  isEnd;

        public TreeNode(){
            next = new HashMap<>();
            isEnd = false;
        }

    }
}
