package org.zyq.tomcat.view;

import org.zyq.core.lang.Str;
import org.zyq.tomcat.CONFIG;
import org.zyq.tomcat.common.BaseJPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

class Button_group extends BaseJPanel {

    private JLabel label_work;
    private JLabel label_jdk;

    public void hook_init() {
        super.hook_init();
        setPreferredSize(new Dimension(500, 20));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        Border border = new EmptyBorder(0, 0, 0, 20);
        Border title = new EmptyBorder(0, 5, 0, 0);
        JLabel jl_for_work = new JLabel("工作目录：");
        jl_for_work.setBorder(title);
        JLabel jl_for_jdk = new JLabel("JDK：");
        jl_for_jdk.setBorder(title);
        label_work = new JLabel();
        label_work.setBorder(border);
        label_jdk = new JLabel();
        label_jdk.setBorder(border);
        label_jdk.setPreferredSize(new Dimension(100, 20));
        label_work.setPreferredSize(new Dimension(50, 20));
        add(jl_for_work);
        add(label_work);
        add(jl_for_jdk);
        add(label_jdk);
        label_work.setText(CONFIG.subject.getWorkspace() == null ? "无" : CONFIG.subject.getWorkspace());
        label_work.setToolTipText(label_work.getText());
        label_jdk.setText(CONFIG.subject.getJDKPath() == null ? "无" : CONFIG.subject.getJDKPath());
        label_jdk.setToolTipText(label_jdk.getText());
        label_work.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2 && Str.notBlank(CONFIG.subject.getWorkspace())) {
                    try {
                        Runtime.getRuntime().exec("explorer " + CONFIG.subject.getWorkspace());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}