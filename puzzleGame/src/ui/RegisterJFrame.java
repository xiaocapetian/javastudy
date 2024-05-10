package ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame(){
        setSize(488,430);
        //设置界面的标题
        setTitle("拼图 注册");
        //设置界面置顶
        setAlwaysOnTop(true);
        //设置界面居中
        setLocationRelativeTo(null);
        //设置关闭模式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //让显示显示出来，建议写在最后

        setVisible(true);
    }
}
