package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/9
 * Time: 15:22
 * Description: No Description
 */
public class MergeSort {
    public static void mergeSort(int[] a){
        mergeSortInternal(a,0,a.length-1);
    }

    private static void mergeSortInternal(int[] a, int leftIndex, int rightIndex) {
        int size = rightIndex-leftIndex+1;
        if (size <= 1){
            return;
        }
        int midIndex = (leftIndex+rightIndex)/2;
        //左区间:leftIndex,midIndex],自己想想0123的时候midIndex是1，所以左半要把midIndex包括进去
        //右区间:[midIndex+1,rightIndex]
        mergeSortInternal(a,leftIndex,midIndex);
        mergeSortInternal(a,midIndex+1,rightIndex);
        //到这里左右两边都是有序的了,接下来用merge左右两个有序区间合并即可
        merge(a,leftIndex,midIndex,rightIndex);
    }

    private static void merge(int[] a, int leftIndex, int midIndex, int rightIndex) {
        int size = rightIndex-leftIndex+1;
        int[] extraArray = new int[size];

        int left = leftIndex; //左半区间指针
        int right = midIndex+1;//右半区间指针
        int extra = 0;//额外数组指针

        while (left <= midIndex && right <= rightIndex){ //有一边的区间没有数取了，就要退出循环
            if (a[left] <= a[right]){
                extraArray[extra] = a[left];
                left++;
                extra++;
            }else {
                extraArray[extra] = a[right];
                right++;
                extra++;
            }
        }

        //把剩下的直接补上就行
        while (left <= midIndex){
            extraArray[extra] = a[left];
            left++;
            extra++;
        }
        while(right <= rightIndex){
            extraArray[extra] = a[right];
            right++;
            extra++;
        }

        //把数组从新数组这里搬回去
        //注意这里的范围，对于数组a不是0到a.length-1，是一部分，从leftIndex到rightIndex
        //对于数组extraArray，是从0到size-1，这里做一个转换，i-leftIndex
        for (int i = leftIndex; i <= rightIndex; i++) {
            a[i] = extraArray[i-leftIndex];
        }
    }
}
