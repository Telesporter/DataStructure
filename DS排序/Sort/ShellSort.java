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
            insertSortByGap(a,i);
        }
    }
    public static void insertSortByGap(int[] a,int gap){
        for (int i = gap; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i-gap; j >= 0 ; j = j-gap) {
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
