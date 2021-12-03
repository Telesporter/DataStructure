package DataStructure.DS01;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/1
 * Time: 21:10
 * Description: No Description
 */
public class 链表逆置 {
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode curNext;
        while (cur != null){
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}