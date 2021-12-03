package DataStructure.DS02;

import java.math.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/2
 * Time: 15:18
 * Description: No Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.nextLine();
        s = scanner.nextLine();
        int ans = s.length()-s.replaceAll("SUST", "").length();
        System.out.println(ans/4);
    }
}
