
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtao
 * @date 2022/2/10
 */
public class ZhConvertToNumber {

    private static Map<String, Integer> unitMap = new HashMap<>();
    private static Map<String, Integer> numMap = new HashMap<>();

    static {
        unitMap.put("十", 10);
        unitMap.put("百", 100);
        unitMap.put("千", 1000);
        unitMap.put("万", 10000);
        unitMap.put("亿", 100000000);
        // num
        numMap.put("零", 0);
        numMap.put("一", 1);
        numMap.put("二", 2);
        numMap.put("三", 3);
        numMap.put("四", 4);
        numMap.put("五", 5);
        numMap.put("六", 6);
        numMap.put("七", 7);
        numMap.put("八", 8);
        numMap.put("九", 9);
    }

    public static int convertToNumber(String chinese){

        return 0;
    }

    public static void main(String[] args) {
        String chinese = "一万零二十一";
        System.out.println(convertToNumber(chinese));
    }
}
