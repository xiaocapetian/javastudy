package day25.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {

    //属性
    //1.牌的名字 格式：数字 - 数字
    private String name;

    //2.牌显示正面还是反面
    private boolean up;

    //3.是否可以被点击
    private boolean canClick = false;

    //4.当前的状态，表示当前的牌是否已经被点击
    //如果是没有被点击的状态，此时被点击了，会执行弹起的操作
    //如果是已经被点击的状态，此时被点击了，会执行降落的操作
    private boolean clicked = false;

    public Poker(String name,boolean up){
        this.name = name;
        this.up = up;
        //判断当前的牌是显示正面还是反面
        if(this.up){
            //显示正面
            turnFront();
        }else{
            //显示反面
            turnRear();
        }
        //设置牌的宽高
        this.setSize(71,96);
        //把牌显示出来
        this.setVisible(true);
        //给每一张牌添加监听
        this.addMouseListener(this);
    }

    //显示正面
    public void turnFront(){
        //给牌设置正面
        //this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\"+name+".png"));
        this.setIcon(new ImageIcon("Takeoff\\src\\day25\\image\\poker\\"+name+".png"));
        //修改成员变量
        this.up = true;
    }

    //显示反面
    public void turnRear(){
        //给牌设置反面

        this.setIcon(new ImageIcon("Takeoff\\src\\day25\\image\\poker\\rear.png"));
        //修改成员变量
        this.up = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //点击
        //判断当前的牌是否可以被点击
        if(canClick){
            //当牌被点击之后，要么升起，要么降落
            //表示牌的位移像素
            int step = 0;
            if(clicked){
                //表示当前的牌已经被点击
                //降落（y 增加 20像素）
                step = 20;
            }else{
                //表示当前的牌还没有被点击
                //升起 （y 减少 20像素）
                step = -20;
            }
            //需要修改一下clicked变量记录的值
            clicked = !clicked;
            //修改一下牌的位置
            Point from = this.getLocation();
            //创建一个Point的对象，表示结束位置
            Point to = new Point(from.x,from.y + step);
            //把最新的位置设置给牌
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
    }
}
