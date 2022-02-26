import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wangtao
 * @date 2022/2/26
 */
public class SimplifyPath {

    private SimplifyPath(){

    }

    public static String simplifyPath(String path) {
        if (path == null || "".equals(path)){
            return "";
        }
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s:paths){
            if (".".equals(s)){
                continue;
            }else if ("..".equals(s)){
                if (!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if (!"".equals(s)){
                stack.offerLast(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.isEmpty()){
            stringBuilder.append("/");
        }
        while (!stack.isEmpty()){
            stringBuilder.append("/").append(stack.pollFirst());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "/home/./";
        System.out.println(simplifyPath(s));
    }


}
