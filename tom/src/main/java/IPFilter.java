import java.util.BitSet;

/**
 * @author wangtao
 * @date 2021/8/17
 */
public class IPFilter {


    private volatile static BitSet high = new BitSet(Integer.MAX_VALUE);
    private volatile static BitSet low = new BitSet(Integer.MAX_VALUE);

    public static String getString(int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if ((num & 1)  == 1){
                sb.append("1");
            }else {
                sb.append("0");
            }
            num = num >> 1;
        }
        return sb.toString();
    }

    private static int ipToInt(String ip){
        if (ip == null || ip.length() == 0){
            return 0;
        }
        String[] tmp = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            sb.append(getString(Integer.valueOf(tmp[i])));
        }
        String intStr = sb.toString();
        if (intStr.indexOf(0) == '1') {

            char[] chars = intStr.toCharArray();
            chars[0]=0;
            intStr = new String(chars);
            return 0 - Integer.valueOf(intStr,2).intValue();
        }
        return Integer.valueOf(intStr, 2).intValue();
    }


    public static boolean addWhiteIpAddress(String ip) {
        int ipInt = ipToInt(ip);
        if (ipInt < 0) {
            high.set(ipInt + Integer.MAX_VALUE + 1);
        } else {
            low.set(ipInt);
        }
        return true;

    }

    public static boolean isInList(String ip){
        int ipInt = ipToInt(ip);
        if (ipInt < 0) {
            return high.get(ipInt+Integer.MAX_VALUE+1);
        } else {
            return low.get(ipInt);
        }
    }
}
