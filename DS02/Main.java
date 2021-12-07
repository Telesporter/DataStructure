package DataStructure.DS02;

import java.math.*;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/2
 * Time: 15:18
 * Description: No Description
 */
public class Main {
    public static <T> void myCompare(T t1, T t2, Comparator<T> comparator){
        int res = comparator.compare(t1,t2);
        if (res > 0){
            System.out.println("T1 is bigger than T2");
        }else if (res < 0){
            System.out.println("T1 is smaller than T2");
        }else {
            System.out.println("T1 is equals to T2");
        }
    }
    public static void main(String[] args) {
        comparatorByAge comparatorByAge = new comparatorByAge();
        Teacher t1 = new Teacher("rpj",22);
        Teacher t2 = new Teacher("xcf",21);
        myCompare(t1,t2,comparatorByAge);
    }
}
