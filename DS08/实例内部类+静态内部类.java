package DataStructure.DS08;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/21
 * Time: 13:59
 * Description: No Description
 */

class A {
    private String a = "aa";
    public A() {
        callName();
    }

    public void callName() {
        System.out.println(a);
    }

    class B extends A {
        private String a = "bb";

        public void callName() {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        A b = new A().new B();
        b.callName();
        System.out.println(b.a);
    }
}

