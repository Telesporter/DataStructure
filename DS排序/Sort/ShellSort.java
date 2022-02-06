package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/5
 * Time: 15:21
 * Description: No Description
 */
public class ShellSort {
    public static void shellSort(int[] a){
        for (int i = a.length/2; i >=1 ; i=i/2) {
            //不断缩小gap，进行分组的插入排序
            insertSortByGap(a,i);
        }
    }
    public static void insertSortByGap(int[] a,int gap){
        //按gap分组进行插入排序
        for (int i = gap; i < a.length; i++) {
            //gap前面的元素没有同组的前一个元素，所以我们从gap开始，
            //也就是gap前面的元素是当前组内是第一个元素，所以默认为该组内的有序部分
            int temp = a[i];
            int j;
            for (j = i-gap; j >= 0 ; j = j-gap) {
                //从当前元素组内的前一个元素开始，在当前组内前面的有序部分寻找合适的位置进行插入
                if (temp < a[j]){
                    a[j+gap] = a[j];
                }else {
                    break;
                }
            }
            a[j+gap] = temp;
        }
    }
}
