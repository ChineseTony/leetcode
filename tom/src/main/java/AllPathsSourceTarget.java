import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/25
 */
public class AllPathsSourceTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        dfs(graph,0,graph.length-1,tmp,result);
        return result;
    }

    private static void dfs(int[][] graph,int index,int len,
                            List<Integer> tmp,
                            List<List<Integer>> result){
        if (index == len){
            result.add(new ArrayList<>(tmp));
        }
        for (int y:graph[index]){
            tmp.add(y);
            dfs(graph,y,len,tmp,result);
            tmp.remove(tmp.size()-1);
        }

    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {4,3,1},{3,2,4},{3},{4},{}
        };
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (List<Integer> tmp:lists){
            System.out.println(Arrays.toString(tmp.toArray(new Integer[0])));
        }
    }

}
