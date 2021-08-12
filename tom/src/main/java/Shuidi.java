import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangtao
 * @date 2021/8/12
 */
public class Shuidi {

    private static final  int personNum = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入编号个数 30
        int N = scanner.nextInt();
        int[] counts = new int[personNum];
        for (int i = 0; i < personNum; i++) {
            counts[i] = scanner.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>(personNum);
        int tmpCount = 0;
        while (tmpCount < N){
            for (int j = 0; j < personNum; j++) {
                if (counts[j] != 0){
                    if (map.containsKey(j)){
                        map.get(j).add(tmpCount);
                    }else {
                        List<Integer> queue = new ArrayList<>();
                        queue.add(tmpCount);
                        map.put(j,queue);
                    }
                    counts[j] --;
                    tmpCount++;
                }
            }
        }
        System.out.println("###");
        for (Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            System.out.println(entry.getKey()+ "--->" +
                    Arrays.toString(entry.getValue().toArray(new Integer[0])));
        }


    }
}
