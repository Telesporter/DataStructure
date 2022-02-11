package DS排序;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2022/2/10
 * Time: 22:52
 * Description: No Description
 */
public class 使用JDK提供的排序方法 {
    public static void main(String[] args) {
        Person[] personArray = createPersonArray(10);
        System.out.println(Arrays.toString(personArray));
        Arrays.sort(personArray, new Comparator<Person>() {
            @Override
            //按年龄从小到大排序
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(Arrays.toString(personArray));



    }



    private static String[] names = { "哈利波特", "张三丰",
            "张三", "李四", "王五", "赵六", "田七", "陈八", "扎官方", "长方形" };



    private static Person[] createPersonArray(int size) {
        Person[] personArray = new Person[size];
        for (int i = 0; i < size; i++) {
            personArray[i] = new Person();
        }

        List<String> namesListOld = Arrays.asList(names);
        List<String> nameList = new ArrayList<>(namesListOld);
        Collections.shuffle(nameList);
        //随机打乱集合中元素的顺序
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            personArray[i].name = nameList.remove(0);
            personArray[i].age = random.nextInt(30) + 5;
            personArray[i].height = random.nextInt(100) + 100;
        }
        return personArray;
    }




}

class Person implements Comparable<Person>{
    String name;
    int age;
    int height;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}