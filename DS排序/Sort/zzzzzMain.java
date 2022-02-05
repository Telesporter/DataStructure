package DS排序.Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 20:09
 * Description: No Description
 */
public class zzzzzMain {
    public static void main(String[] args) {
        int[] a = new int[]{5,2,0,1,3,1,4,6,6};//乱序
        int[] b = new int[]{1,2,3,4,5,6,7,8,9};//有序
        int[] c = new int[]{9,8,7,6,5,4,3,2,1};//逆序
        int[] d = new int[]{1,1,1,1,1,1,1,1,1};//完全相等


        //bubbleSort(a,b,c,d);
        //insertSort(a,b,c,d);
        shellSort(a,b,c,d);
        //selectSort(a,b,c,d);
        //heapSort(a,b,c,d);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
    }
//    public static int[] randomArray(int n){
//        Random random = new Random();
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = random.nextInt(100);
//        }
//        return array;
//    }
    public static void bubbleSort(int[] a,int[] b,int[] c,int[] d){
        BubbleSort.bubbleSort(a);
        BubbleSort.bubbleSort(b);
        BubbleSort.bubbleSort(c);
        BubbleSort.bubbleSort(d);
    }
    public static void insertSort(int[] a,int[] b,int[] c,int[] d){
        InsertSort.insertSort(a);
        InsertSort.insertSort(b);
        InsertSort.insertSort(c);
        InsertSort.insertSort(d);
    }
    public static void shellSort(int[] a,int[] b,int[] c,int[] d){
        ShellSort.shellSort(a);
        ShellSort.shellSort(b);
        ShellSort.shellSort(c);
        ShellSort.shellSort(d);
    }

    public static void selectSort(int[] a,int[] b,int[] c,int[] d){
        SelectSort.selectSort(a);
        SelectSort.selectSort(b);
        SelectSort.selectSort(c);
        SelectSort.selectSort(d);
    }
    public static void heapSort(int[] a,int[] b,int[] c,int[] d){
        HeapSort.heapSort(a);
        HeapSort.heapSort(b);
        HeapSort.heapSort(c);
        HeapSort.heapSort(d);
    }
}
