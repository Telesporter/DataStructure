package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/4
 * Time: 21:16
 * Description: No Description
 */
public class HeapSort {
    public static void heapSort(int a[]){
        createHeap(a,a.length);  //先建大根堆
        for (int i = 0; i < a.length-1; i++) {
            //要n-1轮，每一次选择堆顶元素，也就是下标为0的元素和堆数组最后一个元素进行交换
            int temp = a[0];
            a[0] = a[a.length-1-i];
            a[a.length-1-i] = temp;
            //交换完后，堆的长度要减1，然后对第一个元素进行向下调整
            adjustDown(a,a.length-i-1,0);
        }
    }

    public static void adjustDown(int[] a ,int size, int index){
        //大根堆的向下调整
        while(true){
            int leftIndex = 2*index+1;
            int rightIndex = 2*index+2;
            if (leftIndex > size-1){  //如果没有左孩子，那么一定是叶子结点
                return;
            }

            int maxIndex;
            if (rightIndex > size-1){  //找出两个孩子中值小的那个
                maxIndex = leftIndex;
            }else if (a[rightIndex] < a[leftIndex]){
                maxIndex = leftIndex;
            }else {
                maxIndex = rightIndex;
            }

            if (a[index] >= a[maxIndex]){
                return;
            }else {
                int temp = a[index];
                a[index] = a[maxIndex];
                a[maxIndex] = temp;
                index = maxIndex;
            }

        }
    }

    public static void createHeap(int[] array, int size){
        //时间复杂度NlogN
        //找到层序遍历的最后一个节点的下标
        int lastIndex = size - 1;
        //找到最后一个节点的父节点的下标
        int lastParentIndex = (lastIndex - 1)/2;
        //从[lastParentIndex,0]不断地向下调整
        for (int i = lastParentIndex; i >= 0 ; i--) {
            adjustDown(array,size,i);
        }
    }
}
