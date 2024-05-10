package day36reflect.A02dynamicproxy.mydynamicproxy1;

public interface Star {

    //我们可以把所有想要被代理的方法定义在接口当中

    //唱歌
    String sing(String name);
    //public abstract String sing(String name);

    //跳舞
    void dance();
    //public abstract void dance();


}
