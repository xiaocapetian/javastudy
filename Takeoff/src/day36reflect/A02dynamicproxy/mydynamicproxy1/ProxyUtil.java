package day36reflect.A02dynamicproxy.mydynamicproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
*
* 类的作用：
*       创建一个代理
*
* */
public class ProxyUtil {


    /*
    *
    * 方法的作用：
    *       给一个明星的对象，创建一个代理
    *
    *  形参：
    *       被代理的明星对象(为什么需要这个?动态代理!动态!是给一个内存中的对象!而不是类来创建代理)
    *
    *  返回值：
    *       给明星创建的代理
    *
    *
    *
    * 需求：
    *   外面的人想要大明星唱一首歌
    *   1. 获取代理的对象
    *      代理对象 = ProxyUtil.createProxy(大明星的对象);
    *   2. 再调用代理的唱歌方法
    *      代理对象.唱歌的方法("只因你太美");
    * */
    public static Star createProxy(BigStar bigStar){
       /* java.lang.reflect.Proxy类：提供了为对象产生代理对象的方法：

        public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        参数一：用于指定用哪个类加载器，去加载生成的代理类
        参数二：指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法
        参数三：用来指定生成的代理对象要干什么事情*/
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),//参数一：用于指定用哪个类加载器，去加载生成的代理类
                //什么是类加载器?将字节码文件A.class加载到内存中,所以我就问了,是谁把当前这个类加载到内存中的?
                //你既然能加载当前的类,那你再干一件事:加载当前的代理
                new Class[]{Star.class},//参数二：指定接口，这些接口用于指定生成的代理长什么样，也就是有哪些方法
                //现在写了接口Star,所以可以代理Star接口所以方法

                //参数三：用来指定生成的代理对象要干什么事情.就是会调invoke方法
                //用一个匿名内部类
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        * 参数一 Object proxy：代理的对象(这个一般没用
                        * 参数二 Method method：要运行的方法(代理调了什么方法,这个method就是什么  sing
                        * 参数三 Object[] args：调用sing方法时，传递的实参
                        * */
                        if("sing".equals(method.getName())){
                            System.out.println("准备话筒，收钱");
                        }else if("dance".equals(method.getName())){
                            System.out.println("准备场地，收钱");
                        }
                        //去找大明星开始唱歌或者跳舞
                        //代码的表现形式：调用大明星里面唱歌或者跳舞的方法
                        return method.invoke(bigStar,args);
                        //反射和动态代理的关系!!!!method不就是反射里面获取了成员方法,然后给他对象和参数来执行那个方法嘛!!
                    }
                }
        );
        return star;

    }
}
