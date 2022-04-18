import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangtao
 * @date 2022/4/18
 * @link https://leetcode-cn.com/problems/lexicographical-numbers/
 *
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 *
 * 示例 1：
 *
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LexicalOrder {

    private LexicalOrder(){

    }

    public static List<Integer> lexicalOrder(int n) {
        List<String> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tmp.add(i+"");
        }
        tmp.sort(String::compareTo);
        List<Integer> collect = tmp.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        return collect;
    }

    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> tmp = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            tmp.add(num);
            if (num * 10 <= n){
                num *= 10;
            }else {
                //迭代完成 或者num + 1已经大于 n
                while (num % 10 == 9 || num + 1 > n ){
                    num /= 10;
                }
                num++;
            }

        }

        return tmp;
    }

    public static void main(String[] args) {
        int n = 23;
        List<Integer> tmp = lexicalOrder2(n);
        for (Integer i:tmp){
            System.out.print(i+" ");
        }
    }
}
