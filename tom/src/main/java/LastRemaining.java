import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author wangtao
 * @date 2021/8/16
 */
public class LastRemaining {

    public static int lastRemaining(int n) {
        return n==1 ? 1 : 2*(n/2+1-lastRemaining(n/2));
    }


    public static void main(String[] args) {
        int n = 9;
        System.out.println(lastRemaining(n));

    }
}
