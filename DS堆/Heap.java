package DS堆;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/1/23
 * Time: 23:20
 * Description: No Description
 */
public class Heap {
    //向下调整
    public static void adjustDown(int[] array, int size, int index) {
        //时间复杂度logN
        //size指的是这棵树的结点个数，index指的是根节点的位置
        while (true) {
            // 1. 判断 index 是不是叶子
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {  //如果是叶子，表示向下调整已经完成
                return;
            }

            // 2. 找最小的孩子
            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }

            // 3. 比较最小孩子的值 和 index 位置的值
            if (array[index] <= array[minIndex]) {  //如果堆顶元素的值更小，表示已经不需要调整，return
                return;
            }

            //如果没有return的话，那就是要交换了
            // 4. 交换
            int t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            // 5. 把最小的孩子视为 index，继续循环
            index = minIndex;
        }
    }
    public static void createHeap(int[] array, int size){
        //时间复杂度NlogN
        //找到层序遍历的最后一个节点的下标
        int lastIndex = size - 1;
        //找到最后一个节点的父节点的下标
        int lastParentIndex = (lastIndex - 1)/2;
        //从[lastParentIndex,0]不断地向下调整
        for (int i = lastParentIndex; i >= 0 ; i++) {
            adjustDown(array,size,i);
        }
    }
}
