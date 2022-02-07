package DS排序.Sort;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/7
 * Time: 11:12
 * Description: No Description
 */
public class SortTest测量排序时间 {
    public interface sortMethod{
        String methodName();
        void doMethod(int[] a);
    }

    public static void main(String[] args) {

        int[] a = randomArray(10000);
        //注意这里的sortMethod是接口，所以里面必须是静态的对象才行
        sortMethod[] sortMethods = {
                new bubbleSort(),
                new insertSort(),
                new shellSort(),
                new selectSort(),
                new heapSort()
        };
        for (sortMethod sortMethod : sortMethods) {
            long begin = System.currentTimeMillis();
            sortMethod.doMethod(a);
            long end = System.currentTimeMillis();
            long gap = end-begin;
            System.out.println(sortMethod.methodName()+"花费时间为(毫秒)："+gap);
        }
    }


    public static class bubbleSort implements sortMethod{
        @Override
        public String methodName() {
            return "冒泡排序";
        }

        @Override
        public void doMethod(int[] a) {
            BubbleSort.bubbleSort(a);
        }
    }

    public static class insertSort implements sortMethod {
        @Override
        public String methodName() {
            return "插入排序";
        }

        @Override
        public void doMethod(int[] a) {
            InsertSort.insertSort(a);
        }
    }
        public static class shellSort implements sortMethod{
            @Override
            public String methodName() {
                return "希尔排序";
            }

            @Override
            public void doMethod(int[] a) {
                ShellSort.shellSort(a);
            }
    }
        public static class selectSort implements sortMethod {
            @Override
            public String methodName() {
                return "选择排序";
            }

            @Override
            public void doMethod(int[] a) {
                SelectSort.selectSort(a);
            }
        }
    public static class heapSort implements sortMethod {
        @Override
        public String methodName() {
            return "堆排序";
        }

        @Override
        public void doMethod(int[] a) {
            HeapSort.heapSort(a);
        }
    }

    public static int[] randomArray(int n){
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}
