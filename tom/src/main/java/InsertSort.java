

/**
 * @author wangtao
 * @date 2021/8/17
 */
public class InsertSort<T extends Comparable<T>> {

    public void sort(T[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            T tmp = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j-1].compareTo(tmp) > 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }

    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,-2,-1,12};
        new InsertSort<Integer>().sort(arr);
        for (int i:arr){
            System.out.print(i+"\t");
        }

    }

}
