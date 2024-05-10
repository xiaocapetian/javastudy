package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(603, 680);
        //设置界面的标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        jFrame.setLayout(null);


        //创建一个按钮对象
        JButton jtb = new JButton("点我啊");

        //设置位置和宽高
        jtb.setBounds(0,0,100,50);
        //给按钮添加动作监听
        //jtb:组件对象，表示你要给哪个组件添加事件
        //addActionListener：表示我要给组件添加哪个事件监听（动作监听包含鼠标左键点击，空格）
        //参数：表示事件被触发之后要执行的代码

        //查原码可知，addActionListener要传进去一个ActionListener，而ActionListener是一个接口
        //故其实要传进去一个ActionListener的实现类对象
        //所以最简单的，方法一，是新建一个实现类myActionListener()，重写抽象方法
        //jtb.addActionListener(new myActionListener());
        //但是这不好，因为此类只被用一次

        //方法二,匿名内部类
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The button was clicked,aaa");
            }
        });
        //写法三，自己写一个class MyJFrame extends JFrame implements ActionListener
        //在test4中创建这个MyJFrame的对象

        //把按钮添加到界面当中
        jFrame.getContentPane().add(jtb);
        jFrame.setVisible(true);
    }
}
