package day36reflect.A02dynamicproxy.mydynamicproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBigstartt {
    public static Star createproxy(BigStar bigStar){
        //动态代理怎么写?先想到就是那个匿名内部类复杂,怎么弄出来,先写那个proxy的静态方法
        Star star = (Star) Proxy.newProxyInstance(
                ProxyBigstartt.class.getClassLoader(), //类加载器,直接用本类的 类 的 类加载器
                new Class[]{Star.class},//接口的数组
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("sing")){
                            System.out.println("准备话筒，收钱");
                        }else if(method.getName().equals("dance")){
                            System.out.println("准备场地，收钱");
                        }


                        return method.invoke(bigStar,args);
                    }
                }

        );
        return star;

    }
}
