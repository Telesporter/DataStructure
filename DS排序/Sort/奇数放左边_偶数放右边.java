package DS排序.Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/9
 * Time: 1:10
 * Description: No Description
 */
public class 奇数放左边_偶数放右边 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,0,65,8,9,7,4,69,88,21};
        System.out.println(Arrays.toString(a));
        partition(a);
        System.out.println(Arrays.toString(a));
    }

    private static void partition(int[] a) {
        int leftIndex = 0;
        int rightIndex = a.length-1;
        while (leftIndex < rightIndex){
            while (leftIndex < rightIndex && a[rightIndex]%2 == 0){
                rightIndex--;
            }
            //右边找到奇数放到左边
            a[leftIndex] = a[rightIndex];

            while(leftIndex < rightIndex && a[leftIndex]%2 == 1){
                leftIndex++;
            }
            //左边找到偶数放到右边
            a[rightIndex] = a[leftIndex];
        }
    }

}
