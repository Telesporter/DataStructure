package DS09;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/22
 * Time: 17:09
 * Description: https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=23290&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class 牛客判断栈的弹出序列可能吗 {
    public static void main(String[] args) {

    }
}
//class Solution {
//    public boolean IsPopOrder(int [] pushA,int [] popA) {
//        Stack<Integer> stack = new Stack<>();
//        int p1 = 0;
//        int p2 = 0;
//        //12345
//        //45123
//        while (p2 < popA.length){
//            if(!stack.isEmpty() && stack.peek().equals(popA[p2])){
//                stack.pop();
//                p2++;
//            }else {
//                while (p1 < pushA.length && pushA[p1] != popA[p2]){
//                    stack.push(pushA[p1]);
//                    p1++;
//                }
//                if (p1 >= pushA.length){
//                    //在else分支中，循环如果是因为p1>=length退出，
//                    // 那表明在当前栈顶以及剩下的入栈序列里面都找不到和当前出栈元素相匹配的项，返回false
//                    return false;
//                }
//                stack.push(pushA[p1++]);  //找到相等的元素会退出循环，这里我们还要把他放入栈中
//            }
//        }
//        return true;
//    }
//}


class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int p1 = 0;
        int p2 = 0;
        while(p1 < pushA.length){
            if (pushA[p1] != popA[p2]){
                stack.push(pushA[p1]);
                p1++;
            }else {
                p1++;
                p2++;
                while(!stack.isEmpty() && stack.peek().equals(popA[p2])){
                    stack.pop();
                    p2++;
                }
            }
        }
        return stack.isEmpty();
    }
}