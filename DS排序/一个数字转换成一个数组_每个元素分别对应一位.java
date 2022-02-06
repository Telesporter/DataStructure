package DS排序;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/6
 * Time: 15:31
 * Description: No Description
 */
public class 一个数字转换成一个数组_每个元素分别对应一位 {
    public static int[] change(long data){
        Deque<Integer> stack = new LinkedList<>();
        while (data > 0){
            int digit = (int)(data % 10);
            data = data/10;
            stack.push(digit);
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            //注意这里的ans.length不能写成stack.size()，因为stack的size一直在变化
            ans[i] = stack.pop();
        }
        return ans;
    }


    public static void main(String[] args) {
        long today = 20220206;
        int[] todayArray = change(today);
        System.out.println(Arrays.toString(todayArray));
    }
}
