/**
 * @author wangtao
 * @date 2022/11/6
 */
public class Leetcode1678 {

    public  static String interpret(String command) {
        if (command == null || command.length() == 0) {
            return command;
        }
        int len = command.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < len){
            char c = command.charAt(index);
            if (c == '('){
                if (index + 1 < len  && command.charAt(index+1) == ')'){
                    sb.append("o");
                    index += 2;
                }else {
                    index++;
                    while (index < len && command.charAt(index) != ')'){
                        sb.append(command.charAt(index));
                        index++;
                    }
                    index++;
                }
            }else {
                sb.append(command.charAt(index));
                index++;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));
        command = "G()()()()(al)";
        System.out.println(interpret(command));
        command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
}
