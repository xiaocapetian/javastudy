package CheeseisPower;

public class PassbyValue {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        obj.value = 5;
        modifyObject(obj);
        System.out.println("After modifyObject: " + obj.value); // 输出 10

        reassignObject(obj);
        System.out.println("After reassignObject: " + obj.value); // 输出 10
    }

    //修改对象的属性会影响原对象
    public static void modifyObject(MyObject o) {
        o.value = 10;
    }

    //但重新赋值对象不会影响原对象
    //本来o指向obj所指向的 那个，但是现在o指向了新的一个，有改了它，当然不影响obj指向的东西啦
    public static void reassignObject(MyObject o) {
        o = new MyObject();
        o.value = 20;
    }

//Java 的参数传递方式有时会引起混淆。实际上，Java 只有值传递（Pass by Value），
// 但是对于对象类型参数，传递的是对象引用的副本。因此，修改对象的属性会影响原对象，但重新赋值对象不会影响原对象。

}
class MyObject {
    int value;
}