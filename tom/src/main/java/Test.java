import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangtao
 * @date 2021/8/15
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,4,2,5,0,3,0};

        List<Integer> tmp = new ArrayList<>();
        for (int i:nums){
            tmp.add(i);
        }

        int k = 0;
        Integer zero = new Integer(0);
        while (k < tmp.size()){
            if (tmp.get(k).equals(zero)){
                tmp.remove(k);
            }
            k++;
        }
        System.out.println(Arrays.toString(
                tmp.toArray(new Integer[0])
        ));
        StringBuilder a = new StringBuilder("A");
        StringBuilder b = new StringBuilder("B");
        opeerate(a,b);
        System.out.println(a + "-"+b);
    }



    static void opeerate(StringBuilder x,StringBuilder y){
        x.append(y);
        y = x;
        System.out.println(y);
    }
}
