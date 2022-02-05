package DS排序;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 16:29
 * Description: No Description
 */
public class 输入十六进制转十进制 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入十六进制数，注意字母要大写");
        String s = scanner.nextLine();
        long ans = sixteenToTen(s);
        System.out.printf("%15d",ans);
    }

    private static long sixteenToTen(String s) {
        long ans = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            ans = 16*ans+toDigit(aChar);//这样子A就是*16^5了
        }
        return ans;
    }
    private static int toDigit(char c){ //把每个字符转换成10-15之间的数字
        if (c >= '0' && c <= '9'){
            return c-'0';
        }else if (c >= 'A' && c <= 'Z'){
            return c-'A'+10;
        }else {
            System.out.println("十六进制输入不合法");
            throw new RuntimeException();
        }
    }
}
