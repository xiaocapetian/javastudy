package day26.A03myfunction.a02game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginJFrame extends MyJFrame implements ActionListener {


    JButton go = new JButton("Go");

    public LoginJFrame() {
        //设置图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("Takeoff\\src\\day26\\A03myfunction\\image\\logo.jpg"));

        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    //添加组件

    public void initView() {
        JLabel image = new JLabel(new ImageIcon("Takeoff\\src\\day26\\A03myfunction\\image\\kit.jpg"));
        image.setBounds(100,50,174,174);
        this.getContentPane().add(image);

        go.setFont(new Font(null,1,20));
        go.setBounds(120,274,150,50);
        go.setBackground(Color.WHITE);




        go.addActionListener(super::method1);
        go.addActionListener(this::method1);//也能正常找到父类,不报错

        go.addActionListener(this::method2);//实现本类的方法   ,这个方法不用写括号
        //为什么可以这样干,因为addActionListener()的形参是ActionListener,这是一个函数式接口
        //go.addActionListener();
        //既然要往里面传一个接口的实现类,重写里面的抽象方法,过去只能这样子,让本类来implements(实现)一个ActionListener接口
        go.addActionListener(this);//本类自己就是它的实现类


        this.getContentPane().add(go);
        method2without();

    }

    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 500);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认居中放置
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//置顶
    }


    public void method2without() {

        System.out.println("直接调");
    }
    public void method2(ActionEvent e) {

        System.out.println("本类的方法go按钮被点击了");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按照过去所学,go按钮被点击了");
    }
}
