package DataStructure.DS07;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 19:30
 * Description: No Description
 */
public class MyLinkedList_Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        MyLinkedList myLinkedList2 = new MyLinkedList();
//        myLinkedList.add(1);
//        myLinkedList.add(2);
//        myLinkedList.add(3);
//        myLinkedList.add(4);
//        myLinkedList.add(5);
//        System.out.println(myLinkedList);
//        System.out.println("size:"+myLinkedList.size);
//
//        myLinkedList.add(5,6);
//        System.out.println(myLinkedList);
//        System.out.println("size:"+myLinkedList.size);
//
//        myLinkedList.add(0,100);
//        System.out.println(myLinkedList);
//        System.out.println("size:"+myLinkedList.size);
//
//        myLinkedList.add(4,200);
//        System.out.println(myLinkedList);
//        System.out.println("size:"+myLinkedList.size);
//
//        myLinkedList.add(4,200);
//
//        System.out.println(myLinkedList);
//        System.out.println("size:"+myLinkedList.size);

        myLinkedList2.add(1);
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        myLinkedList2.remove(0);
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        myLinkedList2.add(1);
        myLinkedList2.add(2);
        myLinkedList2.add(3);
        myLinkedList2.add(4);
        myLinkedList2.add(5);
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        System.out.println("删除元素："+myLinkedList2.remove(3));
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        myLinkedList2.remove((Integer)3);
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        System.out.println(myLinkedList2.set(2, 999));
        System.out.println(myLinkedList2);
        System.out.println("size:"+myLinkedList2.size);

        System.out.println(myLinkedList2.get(1));

        MyLinkedList_Iterator it = myLinkedList2.myLinkedList_iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
