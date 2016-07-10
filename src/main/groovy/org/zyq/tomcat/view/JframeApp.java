package org.zyq.tomcat.view;

import org.zyq.tomcat.CONFIG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by 邹宇泉 on 2016/7/9.
 */
public class JframeApp extends JFrame {


    public JframeApp() throws HeadlessException {
        super("tomcat管理工具");
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("文件");
        JMenuItem item_add = new JMenuItem("新增");
        item_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Add(JframeApp.this);
            }
        });
        jMenu.add(item_add);
        jMenu.addSeparator();

        JMenuItem item_dr = new JMenuItem("导入配置文件");
        jMenu.add(item_dr);
        JMenuItem item_save = new JMenuItem("保存配置");
        jMenu.add(item_save);
        jMenu.addSeparator();

        JMenuItem item_work = new JMenuItem("选择工作目录");
        jMenu.add(item_work);
        item_work.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = "D:/";
                if (CONFIG.subject.getWorkspace() != null && !CONFIG.subject.getWorkspace().isEmpty())
                    s = CONFIG.subject.getWorkspace();
                JFileChooser jFileChooser = new JFileChooser(s);
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jFileChooser.showDialog(new JLabel(), "请选择工作目录");
                File dir = jFileChooser.getSelectedFile();
                if (dir != null) {
                    CONFIG.subject.setWorkspace(dir.getAbsolutePath());
//                    SwingUtils.setContent(new Index());
//                    TomcztUtils.saveConfig();
                }
            }
        });

        JMenuItem item_rq = new JMenuItem("选择默认容器");
        jMenu.add(item_rq);
        item_rq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem item_jdk = new JMenuItem("选择jdk");
        jMenu.add(item_jdk);
        item_jdk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = "C:\\Program Files\\Java";
                if (!new File(s).exists()) {
                    if (new File("C:\\Program Files").exists()) s = "C:\\Program Files";
                    else s = "C:\\";
                }
                if (CONFIG.subject.getJDKPath() != null && !CONFIG.subject.getJDKPath().isEmpty())
                    s = CONFIG.subject.getJDKPath();
                JFileChooser jFileChooser = new JFileChooser(s);
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jFileChooser.showDialog(new JLabel(), "请选择JDK路径");
                File dir = jFileChooser.getSelectedFile();
                if (dir != null) CONFIG.subject.setJDKPath(dir.getAbsolutePath());
//                SwingUtils.setContent(new Tomcat_list().$$$getRootComponent$$$());
//                TomcztUtils.saveConfig();
            }
        });
        jMenu.addSeparator();
        JMenuItem item_clear = new JMenuItem("清理工作目录");
        jMenu.add(item_clear);


        JMenuItem item_set = new JMenuItem("设置");
        jMenu.add(item_set);

        jMenu.addSeparator();
        JMenuItem item_exit = new JMenuItem("退出");
        item_exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jMenu.add(item_exit);
        jMenuBar.add(jMenu);
    }
}
