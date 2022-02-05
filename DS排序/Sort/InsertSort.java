package DS排序.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/1
 * Time: 19:19
 * Description: No Description
 */
public class InsertSort {
    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            //这个地方i=0和1都行
            int temp = a[i]; //从无序序列中取出的数，暂时使用temp保存
            //将这个数与有序序列中的数进行比较，从后往前比较
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < a[j]) {  //这里是从小到大排序
                    a[j + 1] = a[j]; //若当前位置不是temp要插入的位置，当前元素后移一位
                } else {
                    break;  //这里表示找到合适的位置了，直接break退出循环
                }
            }
            a[j+1] = temp; //最后将temp的值插入到合适位置，固得名插入排序
        }
    }
}
