package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 21:37
 * Description: No Description
 */
public class SelectSort {
    public static void selectSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int minIndex = i;
            //这里保存最小元素的下标，不要保存最小元素的值
            //最小元素默认是无序序列的第一个元素
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            if (i != minIndex){
                //如果最小元素就是i的话，没有必要交换，就是一个小优化
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
