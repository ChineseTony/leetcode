import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtao
 * @date 2022/2/8
 */
public class RestoreIpAddresses {

    private List<String> result = new ArrayList<>();


    public List<String> restoreIpAddresses(String s) {
        if ( s.length() > 12){
            return result;
        }
        travel(s,0,0);
        return result;
    }

    private void travel(String s,int index,int pointNumber){
        if (pointNumber == 3){
            if (isValid(s,index,s.length()-1)){
                result.add(s);
            }
            return;
        }
        for (int i = index; i < s.length() ; i++) {
            if (isValid(s,index,i)){
                s = s.substring(0,i+1) + "." + s.substring(i+1);
                pointNumber ++;
                travel(s,i+2,pointNumber);
                pointNumber--;
                s = s.substring(0,i+1) + s.substring(i+2);
            }else {
                break;
            }
        }
    }


    public boolean isValid(String s,int start,int end){
        if (start > end){
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int tmp = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            tmp  = tmp * 10 + s.charAt(i) - '0';
            if (tmp > 255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses(s);
        for (String tmp:strings){
            System.out.print(tmp + " ");
        }
    }

}
