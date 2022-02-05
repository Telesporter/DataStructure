package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 20:57
 * Description: No Description
 */
public class BubbleSort {
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            //最外层表示要几轮冒泡排序，n-1轮即可
            boolean isSorted = true;
            //用于优化，如果整个过程中没有发生交换，那就退出循环
            for (int j = 0; j < a.length-i-1; j++) {
                //想想i = 0的时候，要是没有减1,a[j+1]就数组越界了
                //要是真的不想减1，j从1到a.length-i也一样，下面改成a[j-1]
                if (a[j] > a[j+1]){
                    isSorted = false;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if (isSorted){  //如果整个过程中没有发生交换，那就退出循环
                break;
            }
        }
    }
}
