package DataStructure.DS06;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/14
 * Time: 13:04
 * Description: No Description
 */
public class MyInt_ArrayList_Test {
    public static void main(String[] args) {
        MyInt_List list = new MyInt_ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        list.add(0,100);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        list.add(6,200);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        try {
            list.add(-1,300);  //异常
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }

        System.out.println(list.remove((Integer) 9));
        list.remove(6);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        list.set(0,1000);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        System.out.println(list.contains(1000));
        System.out.println(list.indexOf(6));

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("list = "+list);
        System.out.println("size = "+list.size());


        System.out.println("list = "+list);
        System.out.println("size = "+list.size());

        MyInt_List list2 = new MyInt_ArrayList(list);
        System.out.println("list2 = "+list2);
        System.out.println("size2 = "+list2.size());

        MyIterator myIt = list.iterator();
        MyIterator myIt2 = list.iterator();
        while(myIt.hasNext()){
            int temp = myIt.next();
            if(temp == 5){
                myIt.remove();
            }
        }
        while(myIt2.hasNext()){
            System.out.println(myIt2.next());
        }
    }
}
