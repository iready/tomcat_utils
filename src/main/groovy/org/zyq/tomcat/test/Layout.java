package org.zyq.tomcat.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layout {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;

    public static void main(String[] args) {

        JFrame jf = new JFrame("测试程序");
        jf.setSize(WIDTH, HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        JPanel contentPane = new JPanel();
        jf.setContentPane(contentPane);
        JButton b1 = new JButton("工作");
        JButton b2 = new JButton("学习");
        JButton b3 = new JButton("娱乐");
        JButton b4 = new JButton("购物");
        JButton b5 = new JButton("饮食");

        int key = 1;   //1  代表边框布局  2 代表流式布局      3 代表网格布局
        switch (key) {
            case 1:
                BorderLayout lay = new BorderLayout();// 创建一个布局管理器对象，将中间容器设置为此布局管理
                jf.setLayout(lay);
                contentPane.add(b1, "North");// 将五个普通按钮组件分别按照东、南、西、北、中五个方位添加到中间容器中
                contentPane.add(b2, "South");
                contentPane.add(b3, "East");
                contentPane.add(b4, "West");
                contentPane.add(b5, "Center");
                jf.pack();
                break;

            case 2:
                FlowLayout fay = new FlowLayout();
                jf.setLayout(fay);
                contentPane.add(b1);
                contentPane.add(b2);
                contentPane.add(b3);
                contentPane.add(b4);
                contentPane.add(b5);
                break;
            case 3:
                GridLayout gay = new GridLayout(2, 2);
                contentPane.add(b1);
                contentPane.add(b2);
                contentPane.add(b3);
                contentPane.add(b4);
                contentPane.add(b5);
                jf.setLayout(gay);
                break;
            default:
                break;
        }
        jf.pack();
    }
}