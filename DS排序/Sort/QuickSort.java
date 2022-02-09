package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/8
 * Time: 15:14
 * Description: No Description
 */
public class QuickSort {
    public static void quickSort(int[] a){
        quickSortInternal(a,0,a.length-1);
    }
    // 区间是 [leftIndex, rightIndex]
    private static void quickSortInternal(int[] a, int leftIndex, int rightIndex) {
        // 由于是闭区间，所以，区间内个个数需要加个 1
        //当要排序的区间内没有元素，或者只有一个元素的时候，直接return
        //左边下标比右边下标大的时候，区间内没有元素，左边和右边相等的时候，区间内只有一个元素
        if (leftIndex >= rightIndex){
            return;
        }

        //也可以写成下面的这种形式
//        int size = rightIndex - leftIndex + 1;
//        if (size <= 1) {
//            return;
//        }

        // 选择其中一个数（选最左边的） —— a[leftIndex]
        // 执行 partition，小的放左，大的放右
        // keyIndex 是经过 partition 之后，选出来的数最终所在下标
        int keyIndex = partition前后指针法(a, leftIndex, rightIndex);
        // 分别对左右区间进行相同的处理 —— 递归方法
        quickSortInternal(a, leftIndex, keyIndex - 1);
        quickSortInternal(a, keyIndex + 1, rightIndex);
    }

    // 区间是 a[leftIndex, rightIndex]
    // 1. 选择 a[leftIndex] 作为特殊的数
    // 2. 需要遍历整个区间（不能遗漏任何的数）和 选出来的数比较
    // 3. 保证 小于等于的在左边，大于等于的在右边（但没有顺序要求)

    private static void swap(int[] a, int index1, int index2) {
        int t = a[index1];
        a[index1] = a[index2];
        a[index2] = t;
    }

    private static int partition交换法(int[] a, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        // 选择的数是最左边的一个
        int key = a[left];
        // 选择了最左边，从右边先走

        // 停止条件 leftIndex == rightIndex
        // 循环的继续的条件 leftIndex < rightIndex
        while (left < right) {

            while (left < right && a[right] >= key) {
                right--;
            }
            // 说明 [right] 遇到了小的了

            while (left < right && a[left] <= key) {
                left++;
            }
            // 说明 [left] 遇到了大的了

            swap(a, left, right);
        }

        swap(a, leftIndex, left);
        //因为选择了左边，然后从右边开始找比key小的数，如果停下来了，
        // 那当前值一定比key小，所以最后和key换位置

        return left;
    }
    private static int partition挖坑法(int[] a, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        // 选择的数是最左边的一个
        int key = a[left];
        // 选择了最左边，从右边先走

        // 停止条件 leftIndex == rightIndex
        // 循环的继续的条件 leftIndex < rightIndex
        while (left < right) {

            while (left < right && a[right] >= key) {
                right--;
            }
            // 说明 [right] 遇到了小的了
            //把这个小的填到前面的left的坑里去，当前right空出一个坑
            a[left] = a[right];

            while (left < right && a[left] <= key) {
                left++;
            }
            // 说明 [left] 遇到了大的了
            //把这个大的填到后面right的坑里去，当前left空出一个坑
            a[right] = a[left];
        }
        a[left] = key;
        //最后一步填坑
        return left;
    }
    private static int partition前后指针法(int[] a, int leftIndex, int rightIndex) {
        int left = leftIndex+1;
        for (int i = leftIndex+1; i <= rightIndex; i++) {
            if (a[i] < a[leftIndex]){
                swap(a,i,left);
                left++;
            }
        }
        swap(a,leftIndex,left-1);
        return left-1;
    }
}
